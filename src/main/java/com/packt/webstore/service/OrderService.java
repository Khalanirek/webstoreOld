/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.service;

/**
 *
 * @author Piotr Turliński
 */
public interface OrderService {
    
    void processOrder(String productId, int count);
}
