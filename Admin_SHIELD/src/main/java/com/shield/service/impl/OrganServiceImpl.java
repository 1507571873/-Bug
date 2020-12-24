package com.shield.service.impl;

import com.shield.mapper.OrganMapper;
import com.shield.model.Organ;
import com.shield.model.User;
import com.shield.service.OrganService;
import com.shield.utils.JedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.shield.service.impl
 * @ClassName: OrganServiceImpl
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 11:41
 * @Description:
 */
@Service
public class OrganServiceImpl implements OrganService {

    @Resource
    private OrganMapper organMapper;

    @Resource
    private JedisUtils jedisUtils;

    @Override
    public List<Map<String, Object>> queryOrganZtree() {
        List<Organ> list = organMapper.queryOrganZtree();
        return getqueryOrganZtree(list,"dept_0");
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] roleArr) {
        organMapper.removeRoleToUser(userId);
        if (roleArr != null && roleArr.length > 0 ){
            organMapper.addRoleToUser(userId,roleArr);
        }
        User user = organMapper.getUserById(userId);
        String userName = user.getUserName();
        jedisUtils.del(("SHIELD_PERMISSION:"+userName).getBytes());
    }

    @Override
    public List<Map<String, Object>> queryOrganTree(Integer roleId) {
        List<Organ> list = organMapper.queryOrganTree(roleId);
        return queryOrganTree(list,"dept_0");
    }

    private List<Map<String, Object>> queryOrganTree(List<Organ> list,String pid){
        List<Map<String, Object>> list1 =new  ArrayList<>();
        list.forEach(organ -> {
            Map<String,Object> map =null;
            if (pid.equals(organ.getPid())){
                map=new HashMap<>();
                map.put("nocheck",true);
                map.put("checked",organ.isChecked());
                map.put("id",organ.getId());
                map.put("name",organ.getOrganName());
                map.put("type",organ.getType());
                //拼接图像
                if ("dept_0".equals(organ.getPid())){
                    map.put("iconOpen","/commons/orgimg/1_open.png");
                    map.put("iconClose","/commons/orgimg/organ.png");
                }else{
                    //再次进行判断是部门还是人员
                    if (organ.getType()==1){
                        map.put("nocheck",true);
                        map.put("icon","/commons/orgimg/dept2.png");
                    }else if(organ.getSex()==1){
                        map.put("nocheck",false);
                        map.put("icon","/commons/orgimg/nan.png");
                    }else{
                        map.put("nocheck",false);
                        map.put("icon","/commons/预览图_千图网_编号20078485.fw.png");
                    }
                }
                map.put("children",queryOrganTree(list,organ.getId()));
            }
            if (map!=null){
                list1.add(map);
            }
        });
        return list1;
    }


    private List<Map<String, Object>> getqueryOrganZtree(List<Organ> list,String pid){
        List<Map<String, Object>> organList =new  ArrayList<>();
        list.forEach(organ -> {
            Map<String, Object> map = null;
            if (pid.equals(organ.getPid())){
                map=new HashMap<>();
                map.put("id",organ.getId());
                map.put("name",organ.getOrganName());
                map.put("type",organ.getType());
                //拼接图像
                if ("dept_0".equals(organ.getPid())){
                    map.put("iconOpen","/commons/orgimg/1_open.png");
                    map.put("iconClose","/commons/orgimg/organ.png");
                }else{
                    //再次进行判断是部门还是人员
                    if (organ.getType()==1){
                        map.put("icon","/commons/orgimg/dept2.png");
                    }else if(organ.getSex()==1){
                        map.put("icon","/commons/orgimg/nan.png");
                    }else{
                        map.put("icon","/commons/预览图_千图网_编号20078485.fw.png");
                    }
                }
                map.put("children",getqueryOrganZtree(list,organ.getId()));
            }
            if (map!=null){
                organList.add(map);
            }
        });
        return organList;
    }
}
