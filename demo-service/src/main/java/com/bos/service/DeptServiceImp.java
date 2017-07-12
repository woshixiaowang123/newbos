package com.bos.service;

import com.bos.dao.BaseDao;
import com.bos.domain.Dept;
import com.bos.utils.Page;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * deptservice
 * Created by 隔壁老王 on 2017/7/11.
 */
@Service
@Transactional
public class DeptServiceImp implements DeptService {
    @Autowired
    private BaseDao baseDao;
    @Override
    public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params) {
        return baseDao.find(hql,entityClass,params);
    }

    @Override
    public Dept get(Class<Dept> entityClass, Serializable id) {
        return baseDao.get(entityClass,id);
    }

    @Override
    public Page<Dept> findPage(String hql, Page<Dept> page, Class<Dept> entityClass, Object[] params) {
        return baseDao.findPage(hql,page,entityClass,params);
    }

    @Override
    public void saveOrUpdate(Dept entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<Dept> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<Dept> entityClass, Serializable id) {
        baseDao.deleteById(entityClass,id);
    }

    @Override
    public void delete(Class<Dept> entityClass, Serializable[] ids) {
        baseDao.delete(entityClass,ids);
    }
}
