package com.shield.service.impl;

import com.shield.mapper.DeptMapper;
import com.shield.model.Dept;
import com.shield.service.DeptService;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;



/**
 * @author 业务处理层
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    /**
     *查询
     * @return list
     */
    @Override
    public List<Map<String, Object>> queryZTree() {
        List<Dept> list = deptMapper.queryZTree();
        return getZTree(list,0);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void removeMenu(Integer id) {
        deptMapper.removeMenu(id);
    }

    /**
     * 修改
     * @param dept
     */
    @Override
    public void updateUserData(Dept dept) {
        deptMapper.updateUserData(dept);
    }

    /**
     * 新增
     * @param dept
     */
    @Override
    public void saveUserData(Dept dept) {
        deptMapper.saveUserData(dept);
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    @Override
    public Dept queryByIdZTree(Integer id) {
        return deptMapper.queryByIdZTree(id);
    }

    /**
     * 递归
     * @param list
     * @param pid
     * @return
     */
    private List<Map<String, Object>> getZTree(List<Dept> list,Integer pid){
        List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
        list.forEach(Dept-> {
            Map<String, Object> map =null;
            if (pid.equals(Dept.getPid())){
                map=new HashMap<String, Object>();
                map.put("id",Dept.getId());
                map.put("name",Dept.getName());
                map.put("children",getZTree(list,Dept.getId()));
            }
            if (map!=null){
                list1.add(map);
            }
        });
            return list1;
    }
}
