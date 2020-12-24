package com.shield.controller;

import com.shield.model.ContactAddress;
import com.shield.service.ContactAddressService;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("ContactAddressController")
public class ContactAddressController {


    @Resource
    private ContactAddressService contactAddressService;

    /**
     * 新增
     * @param contactAddress
     * @return
     */
    @RequestMapping("addContact")
    @ResponseBody
    public CommonsReturn addContact(ContactAddress contactAddress){
        contactAddressService.addContact(contactAddress);
        return CommonsReturn.success();
    }

    /**
     * 回显
     * @param userId
     * @return
     */
    @RequestMapping("queryContactAllByUserId")
    @ResponseBody
    public CommonsReturn queryContactAllByUserId(Integer userId){
        List<ContactAddress> list=contactAddressService.queryContactAllByUserId(userId);
        return CommonsReturn.success(list);
    }

    /**
     * 修改回显
     * @return
     */
    @RequestMapping("queryAddressById")
    @ResponseBody
    public CommonsReturn queryAddressById(Integer id){
        ContactAddress contactAddress=contactAddressService.queryAddressById(id);
        return CommonsReturn.success(contactAddress);
    }

    /**
     * 修改
     * @param contactAddress
     * @return
     */
    @RequestMapping("updateContact")
    @ResponseBody
    public CommonsReturn updateContact(ContactAddress contactAddress){
        contactAddressService.updateContact(contactAddress);
        return CommonsReturn.success();
    }

    @RequestMapping("deleteContactById")
    @ResponseBody
    public CommonsReturn deleteContactById(Integer id){
        contactAddressService.deleteContactById(id);
        return CommonsReturn.success();
    }
}
