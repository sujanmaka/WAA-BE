package edu.miu.cs545.waa.service;

import edu.miu.cs545.waa.domain.Product;
import edu.miu.cs545.waa.dto.FilterDto;
import edu.miu.cs545.waa.dto.OrderDto;
import edu.miu.cs545.waa.dto.ProductDto;
import edu.miu.cs545.waa.dto.StatusDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDto getProductById(Long id, String userId);

    List<ProductDto> getAllProducts(FilterDto filterDto);
    List<ProductDto> getAllProductsForAUser(FilterDto filterDto, String userId);

    ProductDto createProduct(ProductDto productDto, String userId);

    ProductDto updateProduct(Long id, ProductDto productDto, String userId);

    void deleteProduct(Long id, String userId);

    List<OrderDto> getOrders(Long id, String userId);

    OrderDto updateOrderStatus(Long id, Long orderId, StatusDto statusDto, String userId);

    List<OrderDto> getOrdersForAllProducts(String userId);
}
