package com.nsbm.ebookstore.Model;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;

    private  long book_id;

    private long  userid;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "delivery_date")
    private String deliveryDate;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "note")
    private String note;
}
