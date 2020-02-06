package com.cy.study.model.common;

import lombok.Data;

/**
 * filter节点
 *
 * @author cy
 */
@Data
public class FilterModel {

    private Boolean allowed;

    private String responseCode;

    private String responseMessage;
}
