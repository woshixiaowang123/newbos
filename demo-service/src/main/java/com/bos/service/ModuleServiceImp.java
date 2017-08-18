package com.bos.service;

import com.bos.dao.BaseDao;
import com.bos.domain.Module;
import com.bos.utils.Page;
import com.bos.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Moduleservice
 * Created by 隔壁老王 on 2017/7/11.
 */
@Service
@Transactional
public class ModuleServiceImp implements ModuleService {
    @Autowired
    private BaseDao baseDao;
    @Override
    public List<Module> find(String hql, Class<Module> entityClass, Object[] params) {
        return baseDao.find(hql,entityClass,params);
    }

    @Override
    public Module get(Class<Module> entityClass, Serializable id) {
        return baseDao.get(entityClass,id);
    }

    @Override
    public Page<Module> findPage(String hql, Page<Module> page, Class<Module> entityClass, Object[] params) {
        return baseDao.findPage(hql,page,entityClass,params);

    }

    @Override
    public void saveOrUpdate(Module entity) {
        if (UtilFuns.isEmpty(entity.getId())){
            //说明是新增
           // entity.setState(1);
            //由于表的字段id的生成策略已经变成了手动
           // String uuid=UUID.randomUUID().toString();
           // entity.setId(uuid);
           // entity.getModuleInfo().setId(uuid);
            //Date date=new Date();

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

            Date time=null;
            try {
                time= sdf.parse(sdf.format(new Date()));

            } catch (ParseException e) {

                e.printStackTrace();
            }

            entity.setCreateTime(time);
           entity.setUpdateTime(time);
           // entity.getModuleInfo().setCreateTime(time);
            //entity.getModuleInfo().setUpdateTime(time);


            baseDao.saveOrUpdate(entity);

        }

    }

    @Override
    public void saveOrUpdateAll(Collection<Module> entitys) {
        baseDao.saveOrUpdateAll(entitys);
    }

    @Override
    public void deleteById(Class<Module> entityClass, Serializable id) {


        baseDao.deleteById(entityClass,id);
    }

    @Override
    public void delete(Class<Module> entityClass, Serializable[] ids) {
        //此时,要删除的是一个数组中的id,可以遍历删除,并且要递归删除,要先查出要删除的id的下面有没有子项
       //遍历调用通过id删除的方法
        for (Serializable id : ids) {
            deleteById(Module.class,id);
        }
    }

    @Override
    public void save(Module model) {
        //可以使用快照区修改信息
        Module m = baseDao.get(Module.class, model.getId());
        m.setState(model.getState());
        m.setName(model.getName());
        m.setCpermission(model.getCpermission());
        m.setCurl(model.getCurl());
        m.setCtype(model.getCtype());
        m.setBelong(model.getBelong());
        m.setCwhich(model.getCwhich());
        m.setRemark(model.getRemark());
        m.setOrderNo(model.getOrderNo());
    }
}
