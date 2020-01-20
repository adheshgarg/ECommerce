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
     private String productid;
     private String categoryid;
     private String productname;
     private String productimageurl;
     private Map<String,String> productattributes;
     private int productrating;
     private String productdescription;

     public Product(){}

    public Product(String productId, String categoryID, String productName, String productImageUrl, Map<String, String> productAttributes, int productRating, String productDescription) {
        this.productid = productId;
        categoryid = categoryID;
        this.productname = productName;
        this.productimageurl = productImageUrl;
        this.productattributes = productAttributes;
        this.productrating = productRating;
        this.productdescription = productDescription;
    }
}
