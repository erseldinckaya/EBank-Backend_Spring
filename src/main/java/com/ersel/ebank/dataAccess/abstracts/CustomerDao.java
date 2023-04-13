package com.ersel.ebank.dataAccess.abstracts;

import com.ersel.ebank.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerDao extends JpaRepository<Customer, Integer> {
    Customer findCustomerByCustomerId(int id);
}
