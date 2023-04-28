package com.ersel.ebank.dataAccess.abstracts;

import com.ersel.ebank.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerDao extends JpaRepository<Customer, Integer> {
    Customer findCustomerByCustomerId(int id);
    Customer findCustomerByMail(String mail);
    boolean existsCustomerByMail(String mail); //rule
    Optional<Customer> findCustomerByUsername(String username);
    Customer getCustomerByUsername(String username);
}
