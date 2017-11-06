/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Piotr Turliński
 */
@Repository
public class InMemoryProductRepository implements ProductRepository{
    
    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() 
    {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
            iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch"
                    + "640x1136 display and 8-megapixel rear camera");
            iphone.setCategory("Smart Phone");
            iphone.setManufacturer("Apple");
            iphone.setUnitsInStock(1000);
            
            Product laptop_dell = new Product("P12345", "Dell Inspirion",
            new BigDecimal(700));
            laptop_dell.setDescription("Dell Inspirion 14-inch Laptop (Black)"
                    + "with 3rd Generation Intel Core processors");
            laptop_dell.setCategory("Laptop");
            laptop_dell.setManufacturer("Dell");
            laptop_dell.setUnitsInStock(1000);
            
            Product tablet_Nexus = new Product("P1236", "Nexus 7", new 
        BigDecimal(300));
            tablet_Nexus.setDescription("Google Nexus 7 is the lightests 7 inch "
                    + "tablet With a quad-core Qualcomm Snapdragon S4 Pro processor");
            tablet_Nexus.setCategory("Tablet");
            tablet_Nexus.setManufacturer("Google");
            tablet_Nexus.setUnitsInStock(1000);
            
            listOfProducts.add(iphone);
            listOfProducts.add(laptop_dell);
            listOfProducts.add(tablet_Nexus);
    }
    
    @Override
    public List<Product> getAllProducts()
    {
        return listOfProducts;
    }
    
    @Override
    public List<Product> getProductsByCategory(String category)
    {
        List<Product> productsByCategory = new ArrayList<>();
        
        for (Product product : listOfProducts)
        {
            if (category.equalsIgnoreCase(product.getCategory()))
            {
                productsByCategory.add(product);
            }
        }
        
        return productsByCategory;
    }
    
    @Override
    public Product getProductById(String productId)
    {
        Product productById = null;
        
        for (Product product : listOfProducts)
        {
            if (product != null && product.getProductId() != null
                    && product.getProductId().equals(productId))
            {
                productById = product;
                break;
            }
        }
        
        if (productById == null)
        {
            throw new IllegalArgumentException("No products found with the"
                    + "product id: " + productId);
        }
        
        return productById;
    }
    
    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams)
    {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        
        Set<String> criterias = filterParams.keySet();
        
        if (criterias.contains("brand"))
        {
            for (String brandName: filterParams.get("brand"))
            {
                for (Product product: listOfProducts)
                {
                    if (brandName.equalsIgnoreCase(product.getManufacturer()))
                    {
                        productsByBrand.add(product);
                    }
                }
            }
        }
        
        if (criterias.contains("category"))
        {
            for (String category: filterParams.get("category"))
            {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }
        
        productsByCategory.retainAll(productsByBrand);
        
        return productsByCategory;
    }
    
    @Override
    public List<Product> getProductsByManufacturer(String manufacturer)
    {
        List<Product> productsByManufacturer = new ArrayList<>();
        
        for (Product product : listOfProducts)
        {
            if (product.getManufacturer().equalsIgnoreCase(manufacturer))
            productsByManufacturer.add(product);
        }
        return productsByManufacturer;
    }
    
        @Override
    public List<Product> getProductsByPriceRange(String low, String high)
    {
        List<Product> productsByPriceRange = new ArrayList<>();
        BigDecimal lowThreshold = BigDecimal.valueOf(Long.parseLong(low));
        BigDecimal highThreshold = BigDecimal.valueOf(Long.parseLong(high));
        
        for (Product product : listOfProducts)
        {
            //Price in range <low,high>
            if (product.getUnitPrice().compareTo(lowThreshold) > -1 && 
                highThreshold.compareTo(product.getUnitPrice()) > -1)
                    productsByPriceRange.add(product);
        }
        
        return productsByPriceRange;
    }
    
    @Override
    public void addProduct(Product product)
    {
        listOfProducts.add(product);
    }
}

