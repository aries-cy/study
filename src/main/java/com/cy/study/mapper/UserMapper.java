package com.cy.study.mapper;

import com.cy.study.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * user mapper
 *
 * @author cy
 */
public interface UserMapper extends Mapper<User> {

    /**
     * 根据用户名查询User
     * @param name 用户名
     * @return user信息
     */
    User queryUserByName(String name);

    /**
     * 查询用户列表
     * @return 用户列表
     */
    List<User> queryUsers();
}
