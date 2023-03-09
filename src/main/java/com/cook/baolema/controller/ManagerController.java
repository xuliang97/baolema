package com.cook.baolema.controller;

import com.cook.baolema.pojo.Manager;
import com.cook.baolema.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @GetMapping
    public List<Manager> selectAll(){
        return managerService.selectAll();
    }


}
