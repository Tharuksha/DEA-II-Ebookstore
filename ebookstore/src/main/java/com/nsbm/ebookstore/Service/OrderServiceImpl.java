package com.nsbm.ebookstore.Service;

import com.nsbm.ebookstore.Model.Order;
import com.nsbm.ebookstore.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long orderId, Order order) {
        // Check if the order with the given orderId exists before updating
        if (orderRepository.existsById(orderId)) {
            // Fetch the existing order from the repository
            Optional<Order> existingOrderOptional = orderRepository.findById(orderId);
            if (existingOrderOptional.isPresent()) {
                Order existingOrder = existingOrderOptional.get();

                // Update the fields of the existing order with the new values
                existingOrder.setName(order.getname());
                existingOrder.setContactNumber(order.getContactNumber());
                existingOrder.setDeliveryDate(order.getDeliveryDate());
                existingOrder.setShippingAddress(order.getShippingAddress());
                existingOrder.setNote(order.getNote());

                // Save the updated order
                return orderRepository.save(existingOrder);
            } else {
                // Handle the case where the order with the given ID does not exist
                // You can throw an exception, return null, or handle it based on your requirements
                return null;
            }
        } else {
            // Handle the case where the order with the given ID does not exist
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

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }
}
