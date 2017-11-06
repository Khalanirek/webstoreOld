/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Piotr Turliński
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomerRepository() 
    {
        Customer customer1 = new Customer("1", "Piotr","Polna 3");
        Customer customer2 = new Customer("2", "Michal", "Kasztanowa 5");
        
        listOfCustomers.add(customer1);
        listOfCustomers.add(customer2);
    }
     
    @Override
    public List<Customer> getAllCustomers(){
         
        return listOfCustomers;
    }
}
