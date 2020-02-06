package com.cy.study.service.impl;

import com.cy.study.mapper.UserMapper;
import com.cy.study.model.User;
import com.cy.study.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * user serviceImpl
 *
 * @author cy
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public void login(HttpServletRequest request,String name, String passWorld) throws Exception {
        User user = userMapper.queryUserByName(name);
        if(null!=user){
            if(passWorld.equals(user.getPassWorld())){
                LOGGER.info("登陆成功！");
                setUserSession(request,user);
            }else {
                LOGGER.error("用户名密码错误！");
                throw new Exception("用户名密码错误！");
            }
        }else {
            LOGGER.error("用户名不存在！");
            throw new Exception("用户名不存在！");
        }
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.queryUsers();
    }

    @Override
    public void addUser(User user) throws Exception{
        if(null!=userMapper.queryUserByName(user.getName())){
            throw new Exception("用户已存在");
        }
        userMapper.insert(user);
    }

    private void setUserSession(HttpServletRequest request,User user){
        HttpSession session = request.getSession();
        session.setAttribute(session.getId(),user);
        session.setMaxInactiveInterval(600);
    }
}
