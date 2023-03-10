package com.cook.baolema.controller;

import com.cook.baolema.pojo.Announcement;
import com.cook.baolema.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

/**
 * @author 徐亮
 */
@RestController
@RequestMapping("/announcements")

public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @GetMapping
    public List<Announcement> selectAll(){
        return announcementService.selectAll();
    }

    @GetMapping("/{id}")
    public Announcement selectByID(@PathVariable Integer id){
        return announcementService.selectByID(id);
    }

    @PostMapping
    public String save(@RequestBody Announcement announcement){
//        System.out.println(announcement);
        announcement.setCreatedTime(new Date());
        boolean flag = announcementService.save(announcement);
        if(flag)
            return "保存成功！";
        else
            return "保存失败！";
    }

    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable Integer id){
        boolean flag = announcementService.deleteByID(id);
        if(flag)
            return "删除成功！";
        else
            return "删除失败！";
    }

    @PutMapping
    public String update(@RequestBody Announcement announcement){

        boolean flag = announcementService.update(announcement);
        if(flag)
            return "更新成功！";
        else
            return "更新失败！";
    }
}
