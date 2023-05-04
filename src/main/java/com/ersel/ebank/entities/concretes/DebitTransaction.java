package com.ersel.ebank.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_transaction")
public class DebitTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_transaction_id")
    private int transactionId;
    @Column(name = "destination_id")
    private int destinationId;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private DebitAccount accountId;
    @Column(name = "amount")
    private int amount;
    @Column(name = "transaction_name")
    private String transactionName;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TransactionType typeId;

//    private int typeId;
    @Column(name = "transaction_date")
    private String transactionDate;
}
