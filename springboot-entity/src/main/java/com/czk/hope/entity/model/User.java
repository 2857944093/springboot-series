package com.czk.hope.entity.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/5/12 11:22
 */
@Data
@Api(value = "用户")
public class User {
    @ApiParam(value = "id")
    private Long id;


    @ApiParam(value = "姓名")
    private String name;


    @ApiParam(value = "年龄")
    private Integer age;


    @ApiParam(value = "邮箱")
    private String email;
}
