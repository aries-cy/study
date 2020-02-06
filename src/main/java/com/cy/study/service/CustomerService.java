package com.cy.study.service;


import com.cy.study.model.Customer;
import com.cy.study.model.common.ResponsePageModel;
import com.cy.study.model.request.CustomerRequestModel;

/**
 * 客户管理逻辑
 *
 * @author cy
 */
public interface CustomerService {

    /**
     * 分页查询客户列表
     * @param requestModel 请求参数
     * @return 客户信息
     */
    ResponsePageModel<Customer> getCustomerList(CustomerRequestModel requestModel);

    /**
     * 查询客户详情
     * @param id 主键id
     * @return 客户详情信息
     */
    Customer queryCustomerById(Long id);

    /**
     * 新增一个客户
     * @param customer 客户
     */
    void addCustomer(Customer customer);

    /**
     * 更新客户信息
     * @param customer 客户
     */
    void updateCustomer(Customer customer);

    /**
     * 根据ID删除
     * @param id customer id
     */
    void deleteCustomerById(Long id);
}
