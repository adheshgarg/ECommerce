package com.project.elastic.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Getter
@Setter
public class ProductDTO {
    private String productid;
    private String categoryid;
    private String productname;
    private String productimageurl;
    private Map<String,String> productattributes;
    private int productrating;
    private String productdescription;
}
