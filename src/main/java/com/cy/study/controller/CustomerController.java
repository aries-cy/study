package com.cy.study.controller;

import com.cy.study.model.Customer;
import com.cy.study.model.common.ResponsePageModel;
import com.cy.study.model.common.RestResult;
import com.cy.study.model.constant.ResponseConstant;
import com.cy.study.model.request.CustomerRequestModel;
import com.cy.study.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 客户信息
 *
 * @author cy
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;

    @PostMapping("/pageList")
    public RestResult<ResponsePageModel<Customer>> queryCustomers(CustomerRequestModel requestModel){
        return new RestResult<>(customerService.getCustomerList(requestModel));
    }

    @GetMapping("/queryCustomerById/{id}")
    public RestResult<Customer> queryCustomerDetail(@PathVariable("id")Long id){
        return new RestResult<>(customerService.queryCustomerById(id));
    }

    @PostMapping("/addCustomer")
    public RestResult addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return SUCCESS;
    }

    @PostMapping("/updateCustomer")
    public RestResult updateCustomer(Customer customer, HttpServletRequest request){
        if(!isAdmin(request)){
            return new RestResult(ResponseConstant.NO_POWER,ResponseConstant.NO_POWER_MESSAGE);
        }
        customerService.updateCustomer(customer);
        return SUCCESS;
    }

    @GetMapping("/deleteById/{id}")
    public RestResult deleteById(@PathVariable("id")Long id,HttpServletRequest request){
        if(!isAdmin(request)){
            return new RestResult(ResponseConstant.NO_POWER,ResponseConstant.NO_POWER_MESSAGE);
        }
        customerService.deleteCustomerById(id);
        return SUCCESS;
    }

}
