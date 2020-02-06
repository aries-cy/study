package com.cy.study.model;

import lombok.Data;

import javax.persistence.Id;

/**
 * 客户
 *
 * @author cy
 */
@Data
public class Customer {
    @Id
    private Long id;
    private String name;
    private String sex;
    private Integer age;
    private String phoneNum;
    private String address;
    private String remark;
}
