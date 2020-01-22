package com.project.elastic.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Getter
@Setter
public class ProductDTO {
    @Id
    private String productId;
    private String categoryId;
    private String productName;
    private String imageUrl;
    private Map<String,String> productAttributes;
    private double productPrice;
    private int productRating;
    private String productDescription;
}
