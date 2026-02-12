package com.coding.demo.service;

import com.coding.demo.model.Product;
import com.coding.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product add(Product product) {
        return productRepository.insert(product);
    }

    public List<Product> addBatch(List<Product> products) {
        return productRepository.insert(products);
    }

   @Cacheable(key = "#id", value = "Product")
    public Product getProductById(long id) {
        log.info("connecting to database for getting product");
        return productRepository.findById(id).get();
    }

    @CacheEvict(value = "Product", key = "#id")
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
