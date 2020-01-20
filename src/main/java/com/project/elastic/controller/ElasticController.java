package com.project.elastic.controller;

import com.project.elastic.dto.ProductDTO;
import com.project.elastic.entity.Product;
import com.project.elastic.service.impl.ElasticSeviceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ElasticController {

    @Autowired
    private ElasticSeviceImpl elasticSevice;

    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO newProduct){
        Product saveProduct = new Product();
        BeanUtils.copyProperties(newProduct, saveProduct);
        Product productCreated  = elasticSevice.addProduct(saveProduct);
        return new ResponseEntity<String>(productCreated.getProductid(),HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @GetMapping("/get/{id}")
    public Optional<Product> findById(@PathVariable("id") String id){
        Optional<Product> getProduct = elasticSevice.findById(id);
        return getProduct;
    }



}
