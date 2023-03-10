package com.cook.baolema.dao;

import com.cook.baolema.pojo.Announcement;
import com.cook.baolema.pojo.Dish;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 徐亮
 */
@Mapper
public interface AnnouncementDao {
    /*
 查询所有公告
 * */
    @Select("select * from tb_announcement")
    List<Announcement> selectAll();

    /*
    按id查询公告
     */
    @Select("select * from tb_announcement where announcementID=#{id}")
    Announcement selectByID(Integer id);

    /*
    增加or保存公告
    * */
    @Insert("insert into tb_announcement values (null,#{createdTime},#{url},#{status})")
    int save(Announcement newAnnouncement);

    /*
     * 修改公告信息
     * */
    @Update("update tb_announcement set url=#{url},status=#{status},createdTime=#{createdTime} where announcementID=#{announcementID}")
    int update(Announcement newAnnouncement);

    /*
     * 删除公告
     * */
    @Delete("delete from tb_announcement where announcementID=#{id}")
    int deleteByID(Integer id);
}
