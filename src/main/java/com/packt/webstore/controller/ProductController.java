/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Piotr Turliński
 */
@Controller
@RequestMapping("/products")
public class ProductController 
{
    @Autowired
    private ProductService productService;
    
    @RequestMapping()
    public String list(Model model)
    {
            model.addAttribute("products", productService.getAllProducts());
            
            return "products";
    }
    
    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model,
            @PathVariable("category") String productCategory)
    {
        model.addAttribute("products",
                productService.getProductsByCategory(productCategory));
        
        return "products";
    }
    @RequestMapping("/all")
    public String allProducts(Model model)
    {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    
    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") 
    Map<String, List<String>> filterParams, Model model)
    {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        
        return "products";
    }
    
    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId,
            Model model)
    {
        model.addAttribute("product", productService.getProductById(productId));
        
        return "product";
    }
    
    @RequestMapping("/productss")
    public String filterProducts(Model model)
    {
        Set<Product> filtredProducts = new HashSet<>();
        filtredProducts.addAll(productService.getProductsByCategory("tablet"));
        filtredProducts.retainAll(productService.getProductsByPriceRange("200", "400"));
        filtredProducts.retainAll(productService.getProductsByManufacturer("google"));
        model.addAttribute("products", filtredProducts);
        return "products";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNeProductForm(Model model)
    {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") 
            Product newProduct, BindingResult result)
    {
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0)
        {
            throw new RuntimeException("Attempting to bind disallowed fields: "
            + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        productService.addProduct(newProduct);
        return "redirect:/products";
    }
    
    @InitBinder
    public void initialiseBinder(WebDataBinder binder)
    {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
    }
}
