//package com.cy.study.elasticsearch.service;
//
//import com.cy.study.elasticsearch.dao.UserRepository;
//import com.cy.study.elasticsearch.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.query.GetQuery;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
//@Component
//public class BaseElasticService {
//
//
//    @Resource
//    private ElasticsearchOperations elasticsearchOperations;
//
//    @Autowired
//    UserRepository userRepository;
//
//    public User findById(Long id){
//        return  elasticsearchOperations.queryForObject(GetQuery.getById(id.toString()), User.class);
//    }
//
//}
//
