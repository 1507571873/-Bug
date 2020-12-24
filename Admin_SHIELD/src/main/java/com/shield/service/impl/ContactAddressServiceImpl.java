package com.shield.service.impl;

import com.shield.mapper.ContactAddressMapper;
import com.shield.model.ContactAddress;
import com.shield.service.ContactAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactAddressServiceImpl implements ContactAddressService {

    @Resource
    private ContactAddressMapper contactAddressMapper;

    /**
     * 新增
     * @param contactAddress
     */
    @Override
    public void addContact(ContactAddress contactAddress) {
        contactAddressMapper.addContact(contactAddress);
    }


    /**
     * 回显
     * @param userId
     * @return
     */
    @Override
    public List<ContactAddress> queryContactAllByUserId(Integer userId) {
        return contactAddressMapper.queryContactAllByUserId(userId);
    }

    /**
     * 修改回显
     * @param id
     * @return
     */
    @Override
    public ContactAddress queryAddressById(Integer id) {
        return contactAddressMapper.queryAddressById(id);
    }

    /**
     * 修改
     * @param contactAddress
     */
    @Override
    public void updateContact(ContactAddress contactAddress) {
        contactAddressMapper.updateContact(contactAddress);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteContactById(Integer id) {
        contactAddressMapper.deleteContactById(id);
    }
}
