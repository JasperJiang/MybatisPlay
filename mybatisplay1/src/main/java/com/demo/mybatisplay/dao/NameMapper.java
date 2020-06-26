package com.demo.mybatisplay.dao;

import com.demo.mybatisplay.pojo.Name;

import java.util.List;
import java.util.Map;

public interface NameMapper {

    List<Name> getNameList();

    Name getNameById(int id);

    int addName(Name name);

    int updateName(Name name);

    int deleteNameById(int id);

    //万能的map
    int addName2(Map<String, Object> map);

    List<Name> getNameLike(String name);
}
