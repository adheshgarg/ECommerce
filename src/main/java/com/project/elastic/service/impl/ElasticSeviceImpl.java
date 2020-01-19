package com.project.elastic.service.impl;

import com.project.elastic.repository.ElasticRepository;
import com.project.elastic.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElasticSeviceImpl implements ElasticService {

    @Autowired
    ElasticRepository elasticRepository;
}
