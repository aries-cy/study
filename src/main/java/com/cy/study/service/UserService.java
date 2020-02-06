package com.cy.study.service;

import com.cy.study.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * user service
 *
 * @author cy
 */
public interface UserService {

    /**
     * 登陆校验
     * @param request HttpServletRequest
     * @param name 用户名
     * @param passWorld 密码
     * @throws Exception 异常
     */
    void login(HttpServletRequest request,String name, String passWorld) throws Exception;

    /**
     * 查询列表
     * @return users
     */
    List<User> queryUsers();


    /**
     * 新增用户
     * @param user
     * @throws Exception 异常
     */
    void addUser(User user) throws Exception;

}
