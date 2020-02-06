package com.cy.study.model.request;

import com.cy.study.model.common.RequestPageModel;
import lombok.Data;

/**
 * 客户列表查询请求类
 *
 * @author cy
 */
@Data
public class CustomerRequestModel extends RequestPageModel {

    private String name;
    private String sex;
    private String phoneNum;

}
