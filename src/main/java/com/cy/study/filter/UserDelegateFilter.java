package com.cy.study.filter;

import com.alibaba.fastjson.JSONObject;
import com.cy.study.manager.FilterManager;
import com.cy.study.manager.impl.FilterManagerImpl;
import com.cy.study.model.common.FilterModel;
import com.cy.study.util.SpringUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户信息过滤器
 *
 * @author cy
 */
public class UserDelegateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        FilterManager filterManager = SpringUtil.getBean("FilterManagerImpl", FilterManagerImpl.class);
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        FilterModel filterModel = filterManager.getFilterResult(httpServletRequest);
        if(null!=filterModel&&filterModel.getAllowed()){
            filterChain.doFilter(request,response);
        }else {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(JSONObject.toJSONString(filterModel));
            writer.flush();
        }
    }
}
