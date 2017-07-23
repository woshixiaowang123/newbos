package com.bos.service;

import com.bos.dao.BaseDao;
import com.bos.domain.Dept;
import com.bos.utils.Page;
import com.bos.utils.UtilFuns;
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
        if (UtilFuns.isEmpty(entity.getId())){
            //说明是新增
            entity.setState(1);
        }
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<Dept> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<Dept> entityClass, Serializable id) {
        //通过传过来的id查询dept对象,并判断是否有子元素
        String hql="from Dept where parent.id = ?";
        List<Dept> depts = baseDao.find(hql, entityClass, new Object[]{id});
        //只有要删除的id下没有子类就直接删除,如果有子类就递归删除
        if (depts!=null && depts.size()>0) {
            for (Dept dept : depts) {
               deleteById(Dept.class,dept.getId());
            }
        }
        baseDao.deleteById(entityClass,id);
    }

    @Override
    public void delete(Class<Dept> entityClass, Serializable[] ids) {
        //此时,要删除的是一个数组中的id,可以遍历删除,并且要递归删除,要先查出要删除的id的下面有没有子项
       //遍历调用通过id删除的方法
        for (Serializable id : ids) {
            deleteById(Dept.class,id);
        }
    }
}
