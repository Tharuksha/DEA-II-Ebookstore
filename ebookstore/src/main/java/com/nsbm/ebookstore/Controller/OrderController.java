package com.nsbm.ebookstore.Controller;

import com.nsbm.ebookstore.Model.Order;
import com.nsbm.ebookstore.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order placedOrder = orderService.placeOrder(order);
        return new ResponseEntity<>(placedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(orderId, order);
        return ResponseEntity.ok("Updated Successfully");
    }
}
