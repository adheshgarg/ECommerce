package com.project.elastic.service.impl;

import com.project.elastic.entity.Product;
import com.project.elastic.repository.ElasticRepository;
import com.project.elastic.service.ElasticService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ElasticSeviceImpl implements ElasticService {

    @Autowired
    ElasticRepository elasticRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public Product addProduct(Product product){
       return elasticRepository.save(product);
    }

    public Optional<Product> findById(String id){
        return elasticRepository.findById(id);
    }

    public Iterable<Product> findByName(SearchQuery searchQuery){
        return elasticRepository.search(searchQuery);
    }

    public void deleteById(String id){
        elasticRepository.deleteById(id);
    }

    public Collection<Product> query(String queryString){
        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery("*" + queryString + "*")
                                .lenient(true)
                                .field("productName")
                                .field("productDescription")
                                .field("productAttributes")
                );

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        return elasticsearchTemplate.queryForList(build, Product.class);
    }

    public Collection<Product> fuzzyQuery(String queryText){
        QueryBuilder query = QueryBuilders.multiMatchQuery("*"+queryText+"*")
                .lenient(true)
                .field("productName^2")
                .field("productDescription")
                .field("productttributes")
                .fuzziness(2);

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        return elasticsearchTemplate.queryForList(build, Product.class);
    }
}
