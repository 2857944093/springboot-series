package com.czk.hope.entity.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czk.hope.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/5/12 11:22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<Map<String, String>> findTableAll();

    List<Map<String, String>> findTableByTableName(@Param("tableName") String tableName);
}
