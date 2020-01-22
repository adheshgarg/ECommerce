package com.project.elastic.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;

@Data
@Getter
@Setter
@Builder
@Document(indexName = "productid",type = "product")
public class Product {
     @Id
     private String productId;
     private String categoryId;
     private String productName;
     private String imageUrl;
     private Map<String,String> productAttributes;
     private double productPrice;
     private int productRating;
     private String productDescription;

     public Product(){}

    public Product(String productId, String categoryId, String productName, String imageUrl, Map<String, String> productAttributes, double productPrice, int productRating, String productDescription) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.productAttributes = productAttributes;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.productDescription = productDescription;
    }
}
