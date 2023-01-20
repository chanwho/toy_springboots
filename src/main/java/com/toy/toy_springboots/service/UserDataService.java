package com.toy.toy_springboots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.toy_springboots.dao.UserDataDao;

@Service
public class UserDataService {
    @Autowired
    UserDataDao userDataDao;

    public Object getlist(Object dataMap) {
        String sqlMapId = "UserCRUD.selectFromUSERDATA";
        Object result = userDataDao.getlist(sqlMapId, dataMap);
        return result;
    }
}
