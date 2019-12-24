package com.czk.hope.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author: ChenZK
 * @Create: 2019/12/24 13:39
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCleanCache {

    Class type();

    String name() default "";
}
