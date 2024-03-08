package com.nsbm.ebookstore.Repository;
import com.nsbm.ebookstore.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
    // Add custom queries if needed
}