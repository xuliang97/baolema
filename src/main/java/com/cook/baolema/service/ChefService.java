package com.cook.baolema.service;


import com.cook.baolema.pojo.Chef;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChefService {

    List<Chef> selectAll();
    Chef selectByID(Integer id);
    boolean update(Chef chef);
    boolean save(Chef chef);
    boolean deleteByID(Integer id);
    Chef selectByPhoneAndPwd(String phoneNumber,String password);
    boolean updatePwd(String password,Integer chefID);

}
