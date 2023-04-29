package com.ersel.ebank.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class DebitAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "account_openning_date")
    private String openningDate;
    @Column(name = "account_balance")
    private int balance;
    @Column(name = "account_card_number")
    private String cardNumber;
    @Column(name = "account_exp_date")
    private String expDate;
    @Column(name = "account_cvc")
    private int cvc;
}
