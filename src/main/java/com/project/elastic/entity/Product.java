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
     private String productImageUrl;
     private Map<String,String> productAttributes;
     private int productRating;
     private String productDescription;

     public Product(){}

    public Product(String productId, String categoryID, String productName, String productImageUrl, Map<String, String> productAttributes, int productRating, String productDescription) {
        this.productId = productId;
        categoryId = categoryID;
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.productAttributes = productAttributes;
        this.productRating = productRating;
        this.productDescription = productDescription;
    }
}
