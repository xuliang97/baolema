package com.cook.baolema.controller;

import com.cook.baolema.pojo.Code;
import com.cook.baolema.pojo.Result;
import com.cook.baolema.pojo.UpdatePassword;
import com.cook.baolema.service.ChefService;
import com.cook.baolema.service.CustomerService;
import com.cook.baolema.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/updatepwd")
public class UpdatePwdController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ChefService chefService;


    /*
    * 更新用户密码
    * */
    @PostMapping("/customer")
    public Result updatePwdCustomer(HttpServletRequest req){
        String phoneNumber = req.getParameter("phoneNumber");
        String newPassword = req.getParameter("password");
        boolean flag = customerService.updatePwd(newPassword, phoneNumber);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改密码成功！" : "修改密码失败！");
    }

    @PostMapping("/chef")
    public Result updatePwdChef(HttpServletRequest req){
        String phoneNumber = req.getParameter("phoneNumber");
        String newPassword = req.getParameter("password");
        boolean flag = chefService.updatePwd(newPassword, phoneNumber);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改密码成功！" : "修改密码失败！");
    }

    @PostMapping("/manager")
    public Result updatePwdManager(HttpServletRequest req){
        String phoneNumber = req.getParameter("phoneNumber");
        String newPassword = req.getParameter("password");
        boolean flag = managerService.updatePwd(newPassword, phoneNumber);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改密码成功！" : "修改密码失败！");
    }
}
