package com.cook.baolema.controller;

import com.cook.baolema.respdata.Code;
import com.cook.baolema.pojo.Customer;
import com.cook.baolema.respdata.Result;
import com.cook.baolema.service.CustomerService;
import com.cook.baolema.utils.RandomNumberGenerator;
import com.cook.baolema.utils.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/check")
    public Result checkPhoneNumber(HttpServletRequest req){
        String phoneNumber = req.getParameter("phoneNumber");
        Customer customer = customerService.selectByPhoneNumber(phoneNumber);
        Integer code = customer != null ? Code.PHONENUMBER_EXIST : Code.PHONENUMBER_NOT_EXIST;
        String msg = customer != null ? "手机号已存在！" : "";
        return new Result(code, null, msg);
    }
    @PostMapping
    public Result Register(HttpServletRequest req){
        //先核验验证码
        HttpSession session = req.getSession();
        //获取用户填写的验证码
        String code = req.getParameter("code");

        String autocode =(String) session.getAttribute("autocode");
        if(!autocode.equals(code)){
            return new Result(Code.VERIFICATION_CODE_ERR , null,"验证码错误！");
        }

        //
        String phoneNumber = req.getParameter("phoneNumber");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String profilePhoto = req.getParameter("profilePhoto");
        Customer customer = new Customer();
        customer.setPhoneNumber(phoneNumber);
        customer.setPassword(password);
        customer.setCustomer(username);
        customer.setCreatedTime(new Date());
        if(profilePhoto == null){
            customer.setProfilePhoto("static/customer.jpg");
        }
        boolean flag = customerService.save(customer);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "注册成功！" : "注册失败！");
    }



    @GetMapping("/getcode")
    public void getCode(HttpServletRequest req){
        int randomNumber = RandomNumberGenerator.getRandomNumber(4);
        String code=String.valueOf(randomNumber);//session中保存后台生成的code,为了将来拿出来与用户提交的进行比较。
        String phoneNumber = req.getParameter("phoneNumber");
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(5*60);//设置失效时间为5分钟

        session.setAttribute("autocode",code);
        //成功返回0，失败返回1
        if(phoneNumber!=null){
            //把后台生成的code和所发送的手机号传进发送消息类，调用执行。
            //手机号经过：前端匹配格式正确->后端查询手机号不存在->发送验证码
            SmsService.send(phoneNumber,code);
        }
    }


}
