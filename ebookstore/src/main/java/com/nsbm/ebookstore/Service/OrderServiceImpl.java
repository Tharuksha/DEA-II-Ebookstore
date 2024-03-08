package com.nsbm.ebookstore.Service;

import com.nsbm.ebookstore.Model.Order;
import com.nsbm.ebookstore.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        // Add any additional logic you need to retrieve all orders
        return orderRepository.findAll();
    }

    @Override
    public Order placeOrder(Order order) {
        // Add any additional logic you need before saving the order
        // For example, setting order status, calculating totals, etc.
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long orderId, Order order) {
        // Check if the order with the given orderId exists before updating
        if (orderRepository.existsById(orderId)) {
            // Set the id of the order to update
            order.setId(orderId);
            // Add any additional logic you need before updating the order
            return orderRepository.save(order);
        } else {
            // Handle the case where the order does not exist
            // You can throw an exception, return null, or handle it based on your requirements
            return null;
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        // Check if the order with the given orderId exists before deleting
        if (orderRepository.existsById(orderId)) {
            // Add any additional logic you need before deleting the order
            orderRepository.deleteById(orderId);
        } else {
            // Handle the case where the order does not exist
            // You can throw an exception, log a message, or handle it based on your requirements
        }
    }
    // Implement more methods as needed
}
