package com.cook.baolema.dao;

import com.cook.baolema.pojo.OrderInfo;

import com.cook.baolema.respdata.GradeNumber;

import com.cook.baolema.respdata.HourAndOrderNumber;
import com.cook.baolema.respdata.NumberAndAmount;

import com.cook.baolema.respdata.goodDish;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderInfoDao {
    @Select("select * from tb_order")
    List<OrderInfo> selectAll();

    @Select("select * from tb_order where status=#{stat} order by createdTime limit #{n}")
    List<OrderInfo> selectLimit(short stat, Integer n);

    @Select("select * from tb_order where orderID=#{id}")
    OrderInfo selectByID(Integer id);

    //insert into tb_order values (null,5,0,null,73.5,CURRENT_DATE,null,'1324',5)
    //insert into tb_order(orderID,customerID,`status`,userRatings,totalAmount,createdTime,chefID,uuid,grade) values (null,5,0,null,73.5,CURRENT_DATE,null,'132d4',5)
    @Insert("insert into tb_order(orderID,customerID,status,comment,totalAmount,createdTime,chefID,uuid,grade) values (null,#{customerID},#{status},null,#{totalAmount},#{createdTime},#{chefID},#{uuid},#{grade})")
    int save(OrderInfo newOrderInfo);

    @Update("update tb_order set customerID=#{customerID},status=#{status},comment=#{comment},totalAmount=#{totalAmount},createdTime=#{createdTime},chefID=#{chefID},grade=#{grade} where orderID=#{orderID}")
    int update(OrderInfo newOrderInfo);

    //修改订单评分
    @Update("update tb_order set grade=#{grade} where orderID=#{orderID}")
    int updateGrade(Integer orderID, Integer grade);

    @Delete("delete from tb_order where orderID=#{id}")
    int deleteByID(Integer id);


    @Select("select orderID from tb_order WHERE customerID=#{customerID} and status=0")
    Integer checkOrderID(Integer customerID);

    //修改订单状态
    @Update("update tb_order set status=#{status} where orderID=#{orderID}")
    int updateStatusByOrderID(Integer orderID, short status);

    @Select("select * from tb_order where customerID=#{customerID}")
    List<OrderInfo> selectHistoryOrder(Integer customerID);

    @Select("select orderID from tb_order where uuid=#{uuid}")
    Integer checkOrderIDByuuid(String uuid);

    @Select("SELECT SUM(totalAmount) AS totalAmount FROM `tb_order` WHERE unix_timestamp(createdTime) >= unix_timestamp(date_sub(NOW(), interval 1 MONTH))")
    Float getMonthTotalAmount();

    @Select("select count(*) from tb_order where status=0")
    Integer getUnpreparedOrders();


    //统计订单各星级数量
    @Select("select grade,count(*) number from tb_order GROUP BY grade")
    List<GradeNumber> selectGradeNumber();


    /*
     * 查询今日订单数
     * */
//    @Select("select count(*) from tb_order where Year(createdTime)=#{year} and Month(createdTime)=#{month} and Day(createdTime)=#{day}}]")
//    Integer selectNumberOfOrders(@Param("year")String year,@Param("month")String month,@Param("day")String day);

    @Select("select count(*) as orderNumberOfToday,sum(totalAmount) as orderAmountOfToday from tb_order where Year(createdTime)=#{year} and Month(createdTime)=#{month} and Day(createdTime)=#{day}")
    NumberAndAmount selectAmountAndNumberOfToday(@Param("year") String year, @Param("month") String month, @Param("day") String day);

    /**
     * 根据用户评分返回订单
     */
    @Select("select * from tb_order where grade=#{score}")
    List<OrderInfo> selectByGrade(Integer score);

    /**
     * 查询上个月订单数（分时段）
     */
    @Select("select HOUR(createdTime) as hour,count(*) as numberOfOrders from tb_order where createdTime >= date_sub(now(),interval 1 month) group by hour order by hour")
    List<HourAndOrderNumber> selectOrderOfHour();

    /**
     *
     */
    @Select("SELECT dishID, count(*) AS dishCount FROM tb_order_detail GROUP BY dishID ORDER BY dishCount DESC LIMIT #{limit};")
    List<goodDish> getGoodDishes(Integer limit);
}
