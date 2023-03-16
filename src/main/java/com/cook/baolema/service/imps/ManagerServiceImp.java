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

    @Override
    public boolean update(Manager manager) {
        return managerDao.update(manager)>0;
    }

    @Override
    public boolean save(Manager manager) {
        return managerDao.save(manager)>0;
    }

    @Override
    public boolean deleteByID(Integer id) {
        return managerDao.deleteByID(id)>0;
    }

    @Override
    public Manager selectByPhoneNumber(String phoneNumber) {
        return managerDao.selectByPhoneNumber(phoneNumber);
    }

    @Override
    public Manager selectByPhoneAndPwd(String phoneNumber, String password) {
        return managerDao.selectByPhoneAndPwd(phoneNumber,password);
    }

    @Override
    public boolean updatePwd(String password, Integer managerID) {
        return managerDao.updatePwd(password,managerID)>0;
    }


}
