package com.cook.baolema.service;


import com.cook.baolema.pojo.Chef;

import java.util.List;

public interface ChefService {
    List<Chef> selectAll();
    Chef selectByID(Integer id);
    boolean update(Chef chef);
    boolean save(Chef chef);
    boolean deleteByID(Integer id);
}
