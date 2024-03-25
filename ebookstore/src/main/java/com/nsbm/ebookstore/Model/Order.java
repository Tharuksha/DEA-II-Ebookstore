package com.nsbm.ebookstore.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "delivery_date")
    private String deliveryDate;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "note")
    private String note;

    public Order() {
    }

    // Constructor and getter/setter methods

    public Order(String username, String contactNumber, String deliveryDate, String shippingAddress, String note) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.deliveryDate = deliveryDate;
        this.shippingAddress = shippingAddress;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setUsername(String username) {
        this.name = name;
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
}
