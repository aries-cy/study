package com.cy.study.manager.impl;

import com.cy.study.controller.BaseController;
import com.cy.study.manager.FilterManager;
import com.cy.study.model.User;
import com.cy.study.model.common.FilterModel;
import com.cy.study.model.constant.ResponseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * 鉴权
 *
 * @author cy
 */
@Component("FilterManagerImpl")
public class FilterManagerImpl extends BaseController implements FilterManager {

    private final static Logger LOGGER = LoggerFactory.getLogger(FilterManagerImpl.class);

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Value("${whitePaths}")
    private String whitePaths;

    @Override
    public FilterModel getFilterResult(HttpServletRequest request) {
        FilterModel filterModel = new FilterModel();
        filterModel.setAllowed(true);
        String requestUri = request.getRequestURI();
        if(!isWhitePaths(requestUri)){
            User user = getUser(request);
            if(null!=user){
                return filterModel;
            }else {
                LOGGER.error("用户未登陆");
                filterModel.setAllowed(false);
                filterModel.setResponseCode(ResponseConstant.NOT_LOGIN);
                filterModel.setResponseMessage(ResponseConstant.NOT_LOGIN_MESSAGE);
                return filterModel;
            }
        }else {
            return filterModel;
        }
    }

    private boolean isWhitePaths(String requestUri){
        for (String path:whitePaths.split(";")){
            if(antPathMatcher.match(path,requestUri)){
                return true;
            }
        }
        return false;
    }
}
