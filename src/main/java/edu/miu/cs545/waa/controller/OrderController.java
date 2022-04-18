package edu.miu.cs545.waa.controller;

import edu.miu.cs545.waa.dto.FilterDto;
import edu.miu.cs545.waa.dto.OrderDto;
import edu.miu.cs545.waa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getAllOrders(FilterDto filterDto, Principal principal) {
        return orderService.getAllOrders(filterDto, principal.getName());
    }

    @PostMapping
    public List<OrderDto> createOrders(@RequestBody List<OrderDto> ordersDto, Principal principal) {
        return orderService.createOrders(ordersDto, principal.getName());
    }

    @PutMapping("/{id}")
    public OrderDto updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto, Principal principal) {
        return orderService.updateOrder(id, orderDto, principal.getName());
    }

    @PutMapping("payments/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void makePayment(Principal principal) {
        orderService.makePayment(principal.getName());
    }

    @PutMapping("/{id}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelOrder(@PathVariable Long id, Principal principal) {
        orderService.cancelOrder(id, principal.getName());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id, Principal principal) {
        orderService.deleteOrder(id, principal.getName());
    }

}
