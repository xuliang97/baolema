package com.cook.baolema.service;

import com.cook.baolema.pojo.Manager;

import java.util.List;

/**
 * @author 徐亮
 */
public interface ManagerService {
    List<Manager> selectAll();
    Manager selectByID(Integer id);

    boolean update(Manager manager);
    boolean save(Manager manager);

    boolean deleteByID(Integer id);

}
