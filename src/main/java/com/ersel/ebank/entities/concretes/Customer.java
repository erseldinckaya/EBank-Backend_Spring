package com.ersel.ebank.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_firstname")
    private String firstName;
    @Column(name = "customer_lastname")
    private String lastName;
    @Column(name = "customer_phone")
    private String phone;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_mail")
    private String mail;
    @Column(name = "customer_point")
    private int creditPoint;
    @Column(name = "customer_password")
    private String password;
    @Column(name = "customer_username")
    private String username;
    @Column(name = "customer_role")
    private String role;
//    @OneToMany(mappedBy = "customer")
//    private List<DebitAccount> cards;
}
