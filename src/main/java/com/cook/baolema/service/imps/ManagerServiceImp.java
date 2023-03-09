package com.cook.baolema.service.imps;

import com.cook.baolema.dao.ManagerDao;
import com.cook.baolema.pojo.Manager;
import com.cook.baolema.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 徐亮
 */
@Service
public class ManagerServiceImp implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public List<Manager> selectAll() {
        return managerDao.selectAll();
    }

    @Override
    public Manager selectByID(Integer id) {
        return managerDao.selectByID(id);
    }
}
