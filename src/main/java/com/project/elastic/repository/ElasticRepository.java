package com.project.elastic.repository;

import com.project.elastic.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticRepository extends ElasticsearchRepository<Product,String> {

}
