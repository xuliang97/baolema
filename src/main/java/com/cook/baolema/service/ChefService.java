package com.cook.baolema.service;


import com.cook.baolema.pojo.Chef;

import java.util.List;

public interface ChefService {
    public List<Chef> selectAll();
    public Chef selectByID(Integer id);
    public boolean update(Chef chef);
    public boolean save(Chef chef);
    public boolean deleteByID(Integer id);
}
