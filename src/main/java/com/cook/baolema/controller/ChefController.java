package com.cook.baolema.controller;

import com.cook.baolema.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chef")
public class ChefController {
    @Autowired
    private ChefService chefService;

}
