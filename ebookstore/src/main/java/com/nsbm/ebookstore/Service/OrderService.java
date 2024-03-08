// OrderService.java
package com.nsbm.ebookstore.Service;


import com.nsbm.ebookstore.Model.Order;

import java.util.List;

// OrderService interface
public interface OrderService {
    List<Order> getAllOrders();
    Order placeOrder(Order order);
    void deleteOrder(Long orderId);
    Order updateOrder(Long orderId, Order order);
    // Add more methods as needed
}
