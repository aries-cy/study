package com.cy.study.model.common;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页响应
 *
 * @author cy
 */
@Data
public class ResponsePageModel<T> extends PageModel {

    /**
     * 数据
     */
    private List<T> dataList;

    public ResponsePageModel(List<T> dataList){
        Page page = (Page) dataList;
        this.setPageNum(page.getPageNum());
        this.setStart(page.getPageNum());
        this.setPageSize(page.getPageSize());
        this.setTotal(page.getTotal());
        this.setTotalPage(page.getPages());
        this.setDataList(dataList);
    }
}
