package com.cook.baolema.controller;

import com.cook.baolema.pojo.*;
import com.cook.baolema.service.ChefService;
import com.cook.baolema.service.CustomerService;
import com.cook.baolema.service.ManagerService;
import com.cook.baolema.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
        if(manager == null){
            //如果管理员不存在，那么就直接返回
            return new Result(Code.LOGIN_ERR,null,"手机号或密码错误");
        }

//        if(manager != null){
//            //如果登录成功，将用户的信息（用户对象）保存到session中
//            HttpSession session = request.getSession();
//            session.setAttribute("managerInfo",manager);
//        }
        //如果查询到对应数据，执行生成token的代码
        Map<String,Object> map = new HashMap<>();
        try{
            Map<String,String> payload =  new HashMap<>();
            payload.put("phoneNumber",phoneNumber);
            payload.put("password",password);
            // 生成JWT的令牌
            String token = JwtUtils.createToken(payload);
            // 响应token
            map.put("token",token);
        }catch (Exception e){
            map.put("msg",e.getMessage());
        }
        return new Result(Code.LOGIN_OK,map,"登录成功");
    }

    @PostMapping("/customer")
    public Result customerLogin(HttpServletRequest request){
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        Customer customer = customerService.selectByPhoneAndPwd(phoneNumber, password);
        if(customer == null){
            return new Result(Code.LOGIN_ERR,null,"用户名或密码错误");
        }

//        if(customer != null){
//            HttpSession session = request.getSession();
//            session.setAttribute("customerInfo",customer);
//        }
        Map<String,Object> map = new HashMap<>();
        try{
            Map<String,String> payload =  new HashMap<>();
            payload.put("phoneNumber",phoneNumber);
            payload.put("password",password);
            // 生成JWT的令牌
            String token = JwtUtils.createToken(payload);
            // 响应token
            map.put("token",token);
        }catch (Exception e){
            map.put("msg",e.getMessage());
        }
        return new Result(Code.LOGIN_OK,map,"登录成功");
    }

    @PostMapping("/chef")
    public Result chefLogin(HttpServletRequest request) {
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        Chef chef = chefService.selectByPhoneAndPwd(phoneNumber, password);
        if (chef == null) {
            return new Result(Code.LOGIN_ERR, null, "用户名或密码错误");
        }
//        if(chef != null){
//            HttpSession session = request.getSession();
//            session.setAttribute("chefInfo",chef);
//        }
        Map<String,Object> map = new HashMap<>();
        try{
            Map<String,String> payload =  new HashMap<>();
            payload.put("phoneNumber",phoneNumber);
            payload.put("password",password);
            // 生成JWT的令牌
            String token = JwtUtils.createToken(payload);
            // 响应token
            map.put("token",token);
        }catch (Exception e){
            map.put("msg",e.getMessage());
        }
        return new Result(Code.LOGIN_OK,map,"登录成功");
    }
}
