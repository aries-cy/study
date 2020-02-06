package com.cy.study.manager;

import com.cy.study.model.common.FilterModel;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器鉴权
 *
 * @author cy
 */
public interface FilterManager {

    /**
     * 校验是否请求合法
     * @param request HttpServletRequest
     * @return 过滤对象
     */
    FilterModel getFilterResult(HttpServletRequest request);
}
