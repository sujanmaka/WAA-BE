package edu.miu.cs545.waa.service.impl;

import edu.miu.cs545.waa.domain.Order;
import edu.miu.cs545.waa.domain.Product;
import edu.miu.cs545.waa.dto.FilterDto;
import edu.miu.cs545.waa.dto.OrderDto;
import edu.miu.cs545.waa.enums.Status;
import edu.miu.cs545.waa.exception.DataNotFoundException;
import edu.miu.cs545.waa.exception.UnprocessableException;
import edu.miu.cs545.waa.repository.OrderRepository;
import edu.miu.cs545.waa.repository.ProductRepository;
import edu.miu.cs545.waa.service.OrderService;
import edu.miu.cs545.waa.util.CustomNullAwareBeanUtils;
import edu.miu.cs545.waa.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    private MapperUtils<OrderDto> mapperToOrderDto;
    private MapperUtils<Order> mapperToOrder;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setMapperToOrderDto(MapperUtils<OrderDto> mapperToOrderDto) {
        this.mapperToOrderDto = mapperToOrderDto;
    }

    @Autowired
    public void setMapperToOrder(MapperUtils<Order> mapperToOrder) {
        this.mapperToOrder = mapperToOrder;
    }

    @Override
    public OrderDto saveOrder(Order order) {
        return (OrderDto) mapperToOrderDto.getMap(orderRepository.save(order), new OrderDto());
    }

    @Override
    public OrderDto getOrderById(Long id, String userId) {
        return (OrderDto) mapperToOrderDto.getMap(orderRepository.findByIdAndUserId(id, userId), new OrderDto());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OrderDto> getAllOrders(FilterDto filterDto, String userId) {
        return (List<OrderDto>) mapperToOrderDto.mapList(orderRepository.findAllByUserId(userId), new OrderDto());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OrderDto> createOrders(List<OrderDto> ordersDto, String userId) {
        ordersDto.forEach(orderDto -> {
            Product product = productRepository.getById(orderDto.getProductId());
            Order order = (Order) mapperToOrder.getMap(orderDto, new Order());
            order.setProduct(product);
            order.setStatus(Status.CREATED);
            orderRepository.save(order);
        });
        return ordersDto;
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto, String userId) {
        Order user = (Order) mapperToOrder.getMap(orderDto, new Order());
        Order currentOrder = orderRepository.findByIdAndUserId(id, userId);
        if (currentOrder == null) {
            throw new DataNotFoundException(String.format("Order with id %d not found", id));
        }
        CustomNullAwareBeanUtils.myCopyProperties(user, currentOrder);
        orderRepository.save(currentOrder);
        return orderDto;
    }

    @Override
    public void deleteOrder(Long id, String userId) {
        Order currentOrder = orderRepository.findByIdAndUserId(id, userId);
        if (currentOrder == null) {
            throw new DataNotFoundException(String.format("Order with id %d not found", id));

        }
        if (currentOrder.getStatus().equals(Status.PURCHASED)) {
            throw new UnprocessableException(String.format("Order with id %d already purchased.", id));
        }
        orderRepository.delete(currentOrder);
    }

    @Override
    public void cancelOrder(Long id, String name) {
        Order order = orderRepository.getById(id);
        if (order.getStatus().equals(Status.SHIPPED) || order.getStatus().equals(Status.DELIVERED)) {
            throw new UnprocessableException(String.format("Order with id %d is already shipped or delivered", id));
        }
        if (order.getStatus().equals(Status.CREATED)) {
            order.setStatus(Status.CANCEL);
            orderRepository.save(order);
        }
    }
}
