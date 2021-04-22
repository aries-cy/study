package com.cy.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.cy.study.model.User;
import com.cy.study.model.common.RestResult;
import com.cy.study.model.constant.ResponseConstant;
import com.cy.study.service.TemplateService;
import com.cy.study.service.UserService;
import handler.ConfContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * user控制层
 *
 * @author cy
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @Resource
    private TemplateService templateService;

    @PostMapping( value = "/login")
    public RestResult login(HttpServletRequest request,User user){
        try {
            userService.login(request,user.getName(),user.getPassWorld());
        } catch (Exception e) {
            return new RestResult(ResponseConstant.ERROR,e.getMessage());
        }
        return SUCCESS;
    }

    @GetMapping("/queryUsers")
    public RestResult<List<User>> queryUsers(){
        List<User> users = userService.queryUsers();
        return new RestResult<>(users);
    }

    @PostMapping( value = "/addUser")
    public RestResult addUser(User user){
        try {
            userService.addUser(user);
        } catch (Exception e) {
            return new RestResult(ResponseConstant.ERROR,e.getMessage());
        }
        return SUCCESS;
    }

    @PostMapping("testTemplate")
    public JSONObject templateTest(@RequestBody User user){
        ConfContext confContext = new ConfContext();
        confContext.setVariable("user",user);
        return templateService.getPersonMsg("test",confContext);
    }

}
