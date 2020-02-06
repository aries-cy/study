package com.cy.study.model.common;

import com.cy.study.model.constant.ResponseConstant;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回数据格式统一
 *
 * @author cy
 */
@NoArgsConstructor
@Data
public class RestResult<T> {

    private String responseCode  = ResponseConstant.SUCCESS_CODE;

    private T content;

    public RestResult(T data){
        this.content =  data;
    }

    public RestResult(String responseCode,T data){
        this.responseCode = responseCode;
        this.content =  data;
    }
}
