package com.project.elastic.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;

@Data
@Getter
@Setter
@Builder
@Document(indexName = "product-index")
public class Product {
     String productId;
     String CategoryID;
     String productName;
     String productImageUrl;
     Map<String,String> productAttributes;
     int productRating;
     String productDescription;

     public Product(){}

    public Product(String productId, String categoryID, String productName, String productImageUrl, Map<String, String> productAttributes, int productRating, String productDescription) {
        this.productId = productId;
        CategoryID = categoryID;
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.productAttributes = productAttributes;
        this.productRating = productRating;
        this.productDescription = productDescription;
    }
}
