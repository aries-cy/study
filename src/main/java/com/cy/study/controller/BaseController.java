package com.cy.study.controller;

import com.cy.study.model.User;
import com.cy.study.model.common.RestResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * base controller 处理一些公用的信息
 *
 * @author cy
 */
public abstract class BaseController {
    protected static RestResult<Object> SUCCESS = new RestResult<>();

    /**
     * 从session中获取用户信息
     * @param request HttpServletRequest
     * @return 用户信息
     */
    protected User getUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object user = session.getAttribute(session.getId());
        if(null!=user){
            return (User) user;
        }
        return null;
    }

    protected boolean isAdmin(HttpServletRequest request){
        User user = getUser(request);
        if("1".equals(user.getType())){
            return true;
        }else {
            return false;
        }
    }
}
