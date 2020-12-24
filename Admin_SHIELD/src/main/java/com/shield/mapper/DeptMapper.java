package com.shield.mapper;

import com.shield.model.Dept;

import java.util.List;

public interface DeptMapper {
    List<Dept> queryZTree();

    void removeMenu(Integer id);

    void updateUserData(Dept dept);

    void saveUserData(Dept dept);

    Dept queryByIdZTree(Integer id);
}
