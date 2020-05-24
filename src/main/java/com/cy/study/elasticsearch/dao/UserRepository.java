package com.cy.study.elasticsearch.dao;


import com.cy.study.elasticsearch.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Query creation from method names
 *
 * @author cy
 */
public interface UserRepository extends Repository<User,String> {

    /**
     * 根据姓名和年龄查询
     * @param username username
     * @param age age
     * @return users
     */
    List<User> findByUsernameAndAge(String username, Integer age);


    /**
     * 查询所有
     * @return 所有user
     */
    Iterable<User> findAll();

    /**
     * 增加一个user
     * @param user 参数
     */
    void save(User user);


    /**
     * 根据ID查询
     * @param id ID
     * @return user
     */
    Optional<User> findById(String id);

    /**
     * 根据ID删除
     * @param id ID
     */
    void deleteById(String id);

    /**
     * id 是否存在
     * @param id ID
     * @return 是否存在
     */
    boolean existsById(String id);
}
