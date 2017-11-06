/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.service;

import com.packt.webstore.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Piotr Turliński
 */

public interface ProductService {
    
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByManufacturer(String manufacturer);
    List<Product> getProductsByPriceRange(String low, String high);
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    
    Product getProductById(String productID);
    void addProduct(Product product);
}
