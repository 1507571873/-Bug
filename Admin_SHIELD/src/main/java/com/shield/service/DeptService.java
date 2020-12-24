package com.shield.service;

import com.shield.model.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {
    List<Map<String, Object>> queryZTree();

    void removeMenu(Integer id);

    void updateUserData(Dept dept);

    void saveUserData(Dept dept);

    Dept queryByIdZTree(Integer id);
}
