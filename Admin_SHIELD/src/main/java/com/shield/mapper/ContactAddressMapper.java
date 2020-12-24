package com.shield.mapper;

import com.shield.model.ContactAddress;

import java.util.List;

public interface ContactAddressMapper {
    //新增
    void addContact(ContactAddress contactAddress);
    //回显
    List<ContactAddress> queryContactAllByUserId(Integer userId);
    //修改回显
    ContactAddress queryAddressById(Integer id);
    //修改
    void updateContact(ContactAddress contactAddress);
    //删除
    void deleteContactById(Integer id);
}
