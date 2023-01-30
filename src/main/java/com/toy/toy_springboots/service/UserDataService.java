package com.toy.toy_springboots.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.toy.toy_springboots.dao.UserDataDao;
import com.toy.toy_springboots.utils.Paginations;

@Service
public class UserDataService {
    @Autowired
    UserDataDao userDataDao;

    public Object getlist(Object dataMap) {
        String sqlMapId = "UserCRUD.selectFromUSERDATA";
        Object result = userDataDao.getlist(sqlMapId, dataMap);
        return result;
    }

    public Object getListWithPagination(Object dataMap) {
        Map<String, Object> result = new HashMap<String, Object>();
        int totalCount = (int) this.getTotal(dataMap);
        int currentPage = (int) ((Map<String, Object>) dataMap).get("currentPage");
        Paginations paginations = new Paginations(totalCount, currentPage);
        result.put("paginations", paginations);
        ((Map<String, Object>) dataMap).put("pageBegin", paginations.getPageBegin());
        result.put("resultList", this.getlist(dataMap));
        return result;
    }

    public Object getTotal(Object dataMap) {
        String sqlMapId = "UserCRUD.selectTotal";

        Object result = userDataDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap) {
        String sqlMapId = "UserCRUD.selectOneFromUSERDATA";
        Object result = userDataDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object update(Object dataMap) {
        String sqlMapId = "UserCRUD.updateByUSER_UID";
        Object result = userDataDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object updateAndGetList(Object dataMap) {
        Object result = this.update(dataMap);/* 이미 이 클래스 내에서 update가 있기 때문 */
        result = this.getlist(dataMap);
        return result;
    }

    public Object delete(Object dataMap) {
        String sqlMapId = "UserCRUD.deleteByUSER_UID";
        Object result = userDataDao.delete(sqlMapId, dataMap);
        return result;
    }

    public Object deleteAndGetList(Object dataMap) {
        Object result = this.delete(dataMap);/* 이미 이 클래스 내에서 delete가 있기 때문 */
        result = this.getlist(dataMap);
        return result;
    }

    public Object insertOne(Object dataMap) {
        String sqlMapId = "UserCRUD.createUSERDATA";
        Object result = userDataDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object insertOneAndGetList(Object dataMap) {
        Object result = this.insertOne(dataMap);/* 이미 이 클래스 내에서 insert가 있기 때문 */
        result = this.getlist(dataMap);
        return result;
    }

    public Object insertMulti(Object dataMap) {
        String sqlMapId = "UserCRUD.attachInsertMulti";
        Object result = userDataDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object insertWithFileAndGetList(Object dataMap) {
        Object result = this.insertOne(dataMap);
        result = this.getlist(dataMap);
        return result;
    }

}
