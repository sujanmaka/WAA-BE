package edu.miu.cs545.waa.repository;

import edu.miu.cs545.waa.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByIdAndUserId(Long id, String userId);

    List<Order> findAllByUserId(String userId);
}