package com.cook.baolema.controller;

import com.cook.baolema.pojo.Code;
import com.cook.baolema.pojo.Customer;
import com.cook.baolema.pojo.Dish;
import com.cook.baolema.pojo.Result;
import com.cook.baolema.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public Result selectAll(){
        List<Customer> customer = customerService.selectAll();
        Integer code = customer != null ? Code.GET_OK : Code.GET_ERR;
        String msg = customer != null ? "" : "数据查询失败，请重试！";
        return new Result(code,customer,msg);
    }
    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id){
        Customer customer = customerService.selectByID(id);
        Integer code = customer != null ? Code.GET_OK : Code.GET_ERR;
        String msg = customer != null ? "" : "数据查询失败，请重试！";
        return new Result(code,customer,msg);
    }
    @PostMapping
    public Result save(@RequestBody Customer customer){
        customer.setCreatedTime(new Date());
        if(customer.getProfilePhoto() == null){
            customer.setProfilePhoto("static/customer.jpg");
        }
        boolean flag = customerService.save(customer);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");

    }
    @PostMapping("/update")
    public Result update(@RequestBody Customer customer){
        boolean flag = customerService.update(customer);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "修改成功！" : "修改失败！");
    }
    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id){
        boolean flag = customerService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");
    }

}
