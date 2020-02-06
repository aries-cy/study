package com.cy.study.mapper;

import com.cy.study.model.Customer;
import com.cy.study.model.request.CustomerRequestModel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 客户管理
 *
 * @author cy
 */
public interface CustomerMapper extends Mapper<Customer> {

    /**
     * 根据条件分页查询客户信息
     * @param requestModel 请求参数
     * @return 客户信息
     */
    List<Customer> queryCustomerPageList(@Param("requestModel") CustomerRequestModel requestModel);

    /**
     * 根据id查询详情
     * @param id 主键id
     * @return 客户详情信息
     */
    Customer queryCustomerById(Long id);

    /**
     * 根据ID删除客户
     * @param id ID
     */
    void deleteById(Long id);

}
