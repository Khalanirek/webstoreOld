/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.service;

import com.packt.webstore.domain.Customer;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Piotr Turliński
 */

public interface CustomerService {
    
    List<Customer> getAllCustomers();
}
