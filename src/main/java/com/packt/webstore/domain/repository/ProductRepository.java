/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Piotr Turliński
 */
public interface ProductRepository {
    
    List<Product> getAllProducts();
    
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByManufacturer(String manufacturer);
    List<Product> getProductsByPriceRange(String low, String high);
    public Product getProductById(String productId);
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParamms);
    void addProduct(Product product);
}
