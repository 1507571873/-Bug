package com.shield.controller;

import com.shield.model.EduXperience;
import com.shield.service.EduXperiencesService;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 唐吉诃德
 */
@Controller
@RequestMapping("EduXperiencesController")
public class EduXperiencesController {

    @Resource
    private EduXperiencesService eduXperiencesService;

    /**
     * 数据展示
     * @param userId
     * @return
     */
    @RequestMapping("queryEduXperData")
    @ResponseBody
    public CommonsReturn queryEduXperData(Integer userId){
        List<EduXperience> list = eduXperiencesService.queryEduXperData(userId);
        return CommonsReturn.success(list);
    }

    /**
     * 新增
     * @param eduXperience
     * @return
     */
    @RequestMapping("addEduXper")
    @ResponseBody
    public CommonsReturn addEduXper(EduXperience eduXperience){
        eduXperiencesService.addEduXper(eduXperience);
        return CommonsReturn.success();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("deleteEduXper")
    @ResponseBody
    public CommonsReturn deleteEduXper(Integer id){
       eduXperiencesService.deleteEduXper(id);
        return CommonsReturn.success();
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("queryEduXperById")
    @ResponseBody
    public CommonsReturn queryEduXperById(Integer id){
        EduXperience eduXperience =  eduXperiencesService.queryEduXperById(id);
        return CommonsReturn.success(eduXperience);
    }

    /**
     * 修改
     * @param eduXperience
     * @return
     */
    @RequestMapping("updateEduXper")
    @ResponseBody
    public CommonsReturn updateEduXper(EduXperience eduXperience){
        eduXperiencesService.updateEduXper(eduXperience);
        return CommonsReturn.success();
    }


}
