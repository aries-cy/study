package com.cy.study.service.impl;

import com.cy.study.mapper.CustomerMapper;
import com.cy.study.model.Customer;
import com.cy.study.model.common.ResponsePageModel;
import com.cy.study.model.request.CustomerRequestModel;
import com.cy.study.service.CustomerService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户管理逻辑
 *
 * @author cy
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;


    @Override
    public ResponsePageModel<Customer> getCustomerList(CustomerRequestModel requestModel) {
        PageHelper.startPage(requestModel.getPageNum(),requestModel.getPageSize());
        List<Customer> customers = customerMapper.queryCustomerPageList(requestModel);
        return new ResponsePageModel<>(customers);
    }

    @Override
    public Customer queryCustomerById(Long id) {
        return customerMapper.queryCustomerById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerMapper.deleteById(id);
    }

}
