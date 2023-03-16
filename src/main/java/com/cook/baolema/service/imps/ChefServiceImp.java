package com.cook.baolema.service.imps;

import com.cook.baolema.dao.ChefDao;
import com.cook.baolema.pojo.Chef;
import com.cook.baolema.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefServiceImp implements ChefService {
    @Autowired
    private ChefDao chefDao;

    @Override
    public List<Chef> selectAll() {
        return chefDao.selectAll();
    }

    @Override
    public Chef selectByID(Integer id) {
        return chefDao.selectByID(id);
    }

    @Override
    public boolean update(Chef chef) {
        return chefDao.update(chef)>0;
    }

    @Override
    public boolean save(Chef chef) {
        return chefDao.save(chef)>0;
    }

    @Override
    public boolean deleteByID(Integer id) {
        return chefDao.deleteByID(id)>0;
    }

    @Override
    public Chef selectByPhoneAndPwd(String phoneNumber, String password) {
        return chefDao.selectByPhoneAndPwd(phoneNumber,password);
    }

    @Override
    public boolean updatePwd(String password, String  phoneNumber) {
        return chefDao.updatePwd(password,phoneNumber)>0;
    }
}
