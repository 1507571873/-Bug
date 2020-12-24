package com.shield.controller;

import com.shield.model.Honor;
import com.shield.service.HonorService;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("HonorController")
public class HonorController {

    @Resource
    private HonorService honorService;

    /**
     * 新增
     * @param honor
     * @return
     */
    @RequestMapping("addHonor")
    @ResponseBody
    public CommonsReturn addHonor(Honor honor){
        honorService.addHonor(honor);
        return CommonsReturn.success();
    }

    /**
     * 数据展示
     * @param userId
     * @return
     */
    @RequestMapping("queryHonorDataByUserId")
    @ResponseBody
    public CommonsReturn queryHonorDataByUserId(Integer userId){
        List<Honor> honorList = honorService.queryHonorDataByUserId(userId);
        return CommonsReturn.success(honorList);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("queryHonorById")
    @ResponseBody
    public CommonsReturn queryHonorById(Integer id){
        Honor honor =  honorService.queryHonorById(id);
        return CommonsReturn.success(honor);
    }

    /**
     * 修改
     * @param honor
     * @return
     */
    @RequestMapping("updateHonor")
    @ResponseBody
    public CommonsReturn updateHonor(Honor honor){
        honorService.updateHonor(honor);
        return CommonsReturn.success();
    }

    @RequestMapping("deleteHonorById")
    @ResponseBody
    public CommonsReturn deleteHonorById(Integer id){
        honorService.deleteHonorById(id);
        return CommonsReturn.success();
    }

}
