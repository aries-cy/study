//package com.cy.study.elasticsearch.dao;
//
//import com.cy.study.elasticsearch.model.User;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.CrudRepository;
//
///**
// * 分页等查询
// *
// * @author cy
// */
//public interface PagingAndSortingRepository extends CrudRepository<User,String> {
//
//    /**
//     * 排序查询
//     * @param sort 排序
//     * @return  Iterable
//     */
//    Iterable<User> findAll(Sort sort);
//
//
//    /**
//     * 分页查询
//     * @param pageable page
//     * @return Page
//     */
//    Page<User> findAll(Pageable pageable);
//
//}
