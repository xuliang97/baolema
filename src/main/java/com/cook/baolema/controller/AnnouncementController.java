package com.cook.baolema.controller;

import com.cook.baolema.pojo.Announcement;
import com.cook.baolema.respdata.Result;
import com.cook.baolema.respdata.Code;
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
    public Result selectAll() {
        List<Announcement> announcements = announcementService.selectAll();
        Integer code = announcements != null ? Code.GET_OK : Code.GET_ERR;
        String msg = announcements != null ? "" : "数据查询失败，请重试！";
        return new Result(code, announcements, msg);
    }

    @GetMapping("/{id}")
    public Result selectByID(@PathVariable Integer id) {
        Announcement announcement = announcementService.selectByID(id);
        Integer code = announcement != null ? Code.GET_OK : Code.GET_ERR;
        String msg = announcement != null ? "" : "数据查询失败，请重试！";
        return new Result(code, announcement, msg);

    }

    @PostMapping
    public Result save(@RequestBody Announcement announcement) {
//        System.out.println(announcement);
        announcement.setCreatedTime(new Date());
        boolean flag = announcementService.save(announcement);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, flag ? "保存成功！" : "保存失败！");

    }

    @GetMapping("/delete/{id}")
    public Result deleteByID(@PathVariable Integer id) {
        boolean flag = announcementService.deleteByID(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag, flag ? "删除成功！" : "删除失败！");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Announcement announcement) {
        boolean flag = announcementService.update(announcement);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, flag ? "更新成功！" : "更新失败！");
    }
}
