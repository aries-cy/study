package com.cy.study.model.common;

import lombok.Data;

/**
 * 分页信息
 *
 * @author cy
 */
@Data
public class PageModel {
    /**
     * 页数
     */
    private Integer pageNum;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 开始
     */
    private Integer start;
}
