package com.czk.hope.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czk.hope.api.service.GeneratorService;
import com.czk.hope.entity.model.User;
import com.czk.hope.entity.repository.UserMapper;
import com.czk.hope.generator.util.GenUtils;
import com.czk.hope.util.jpa.CrudService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/25 16:16
 */
@Service
public class GeneratorServiceImpl extends ServiceImpl<UserMapper, User> implements GeneratorService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String, String>> listTable() {
        return userMapper.findTableAll();
    }

    @Override
    public List<Map<String, String>> queryTable(String tableName) {
        return userMapper.findTableByTableName(tableName);
    }


    @Override
    public byte[] generatorCode() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        //查询所有表
        List<Map<String, String>> list = this.listTable();

        list.forEach(e -> {
            e.forEach((k, v) -> {
                //查询列信息
                List<Map<String, String>> columns = userMapper.findTableByTableName(e.get("tableName"));
                //生成代码
                GenUtils.generatorCode(e, columns, zip);
            });
        });
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }


}
