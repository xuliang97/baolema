package com.cook.baolema.controller;

import com.cook.baolema.pojo.*;
import com.cook.baolema.service.ChefService;
import com.cook.baolema.service.CustomerService;
import com.cook.baolema.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ChefService chefService;

    @PostMapping("/manager")
    public Result managerLogin(HttpServletRequest request){
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        Manager manager = managerService.selectByPhoneAndPwd(phoneNumber, password);
        Integer code = manager != null ? Code.LOGIN_OK : Code.LOGIN_ERR;
        String msg = manager != null ? "登录成功！" : "手机号或密码错误！";
        if(manager != null){
            //如果登录成功，将用户的信息（用户对象）保存到session中
            HttpSession session = request.getSession();
            session.setAttribute("managerInfo",manager);
        }
        return new Result(code, manager.getManagerID(), msg);

    }
    @PostMapping("/customer")
    public Result customerLogin(HttpServletRequest request){
        String phoneNumber = request.getParameter("phoneNumber");
//        System.out.println(phoneNumber);

        String password = request.getParameter("password");
//        System.out.println(password);
        Customer customer = customerService.selectByPhoneAndPwd(phoneNumber, password);

        Integer code = customer != null ? Code.LOGIN_OK : Code.LOGIN_ERR;
        String msg = customer != null ? "登录成功！" : "手机号或密码错误！";
        if(customer != null){
            HttpSession session = request.getSession();
            session.setAttribute("customerInfo",customer);
        }
        return new Result(code,customer.getCustomerID(), msg);

    }
    @PostMapping("/chef")
    public Result chefLogin(HttpServletRequest request){
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        Chef chef = chefService.selectByPhoneAndPwd(phoneNumber, password);
        Integer code = chef != null ? Code.LOGIN_OK : Code.LOGIN_ERR;
        String msg = chef != null ? "登录成功！" : "手机号或密码错误！";
        if(chef != null){
            HttpSession session = request.getSession();
            session.setAttribute("chefInfo",chef);
        }
        return new Result(code, chef.getChefID(), msg);
    }


}
