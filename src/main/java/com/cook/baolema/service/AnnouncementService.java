package com.cook.baolema.service;


import com.cook.baolema.pojo.Announcement;
import java.util.List;

/**
 * @author 徐亮
 */
public interface AnnouncementService {
    public List<Announcement> selectAll();
    public Announcement selectByID(Integer id);
    public boolean deleteByID(Integer id);
    public boolean update(Announcement announcement);
    public boolean save(Announcement announcement);

}
