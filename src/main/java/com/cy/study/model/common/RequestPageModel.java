package com.cy.study.model.common;

import lombok.Data;

/**
 * 分页请求
 *
 * @author cy
 */
@Data
public class RequestPageModel {
    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 页面大小
     */
    private Integer pageSize;
}
