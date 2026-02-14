package com.coding.demo.controller;

import com.coding.demo.model.Product;
import com.coding.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/batch")
    public List<Product> addProductBatch(@RequestBody List<Product> products) {
        return productService.addBatch(products);
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/batch")
    public List<Product> products() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product products(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public Product removeProduct(@PathVariable long id)
    {
        try
        {
            Product product = productService.getProductById(id);
            productService.deleteById(id);
            return product;
        }
        catch (Exception e)
        {
            return null;
        }
    }


}
