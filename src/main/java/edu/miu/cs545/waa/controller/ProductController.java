package edu.miu.cs545.waa.controller;

import edu.miu.cs545.waa.dto.FilterDto;
import edu.miu.cs545.waa.dto.OrderDto;
import edu.miu.cs545.waa.dto.ProductDto;
import edu.miu.cs545.waa.dto.StatusDto;
import edu.miu.cs545.waa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAllProducts(FilterDto filterDto, Principal principal) {
        return productService.getAllProducts(filterDto, principal.getName());
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto, Principal principal) {
        return productService.createProduct(productDto, principal.getName());
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto, Principal principal) {
        return productService.updateProduct(id, productDto, principal.getName());
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id, Principal principal) {
        productService.deleteProduct(id, principal.getName());
    }

    @GetMapping("{id}/orders")
    public List<OrderDto> getOrders(@PathVariable Long id, Principal principal) {
        return productService.getOrders(id, principal.getName());
    }

    @PutMapping("{id}/orders/{orderId}")
    public OrderDto updateOrderStatus(@PathVariable Long id, @PathVariable Long orderId, @RequestBody StatusDto statusDto, Principal principal) {
        return productService.updateOrderStatus(id, orderId, statusDto, principal.getName());
    }

}
