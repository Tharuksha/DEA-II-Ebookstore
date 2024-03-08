package com.nsbm.ebookstore.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String contactNumber;
    private String deliveryDate;
    private String time;
    private String shippingAddress;
    private String note;




    public Order() {
    }

    // Parameterized constructor
    public Order(String userName, String contactNumber, String deliveryDate, String time, String shippingAddress, String note) {
        this.userName = userName;
        this.contactNumber = contactNumber;
        this.deliveryDate = deliveryDate;
        this.time = time;
        this.shippingAddress = shippingAddress;
        this.note = note;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // Additional logic for managing id
    @PreRemove
    private void preRemove() {
        // Capture the id before deletion
        Long deletedId = this.id;

        // Perform the removal logic
        // (This logic depends on how you remove entities, e.g., using Spring Data JPA repository)
        // For example, using Spring Data JPA repository:

        // orderRepository.deleteById(deletedId);

        // Update the remaining records' ids
        if (deletedId != null) {
            updateRemainingIds(deletedId);
        }
    }

    private void updateRemainingIds(Long deletedId) {
        // You need to implement a method to update the remaining records' ids.
        // For example, you can use a custom query to update ids in the database.
        // The exact logic would depend on your data access technology (e.g., Spring Data JPA, Hibernate, etc.).

        // Example (using Spring Data JPA):
        // orderRepository.updateIdsAfterDeletion(deletedId);
    }
}

