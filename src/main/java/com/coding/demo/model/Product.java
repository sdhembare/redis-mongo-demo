package com.coding.demo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
public class Product {
    private long id;
    private String name;
    private int qty;
    private int price;
}
