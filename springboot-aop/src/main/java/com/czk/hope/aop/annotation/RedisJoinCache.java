package com.czk.hope.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:38
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisJoinCache {

    Class type();

}
