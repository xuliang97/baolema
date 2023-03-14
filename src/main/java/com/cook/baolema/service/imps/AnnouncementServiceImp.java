package com.cook.baolema.service.imps;

import com.cook.baolema.dao.AnnouncementDao;
import com.cook.baolema.pojo.Announcement;
import com.cook.baolema.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 徐亮
 */
@Service
public class AnnouncementServiceImp implements AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;
    @Override
    public List<Announcement> selectAll() {
        return announcementDao.selectAll();
    }

    @Override
    public Announcement selectByID(Integer id) {
        return announcementDao.selectByID(id);
    }

    @Override
    public boolean deleteByID(Integer id) {
        return announcementDao.deleteByID(id)>0;
    }

    @Override
    public boolean update(Announcement announcement) {
        return announcementDao.update(announcement)>0;
    }

    @Override
    public boolean save(Announcement announcement) {
        return announcementDao.save(announcement)>0;
    }
}
