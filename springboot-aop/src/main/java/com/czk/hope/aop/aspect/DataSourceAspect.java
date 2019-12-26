package com.czk.hope.aop.aspect;

import com.czk.hope.aop.annotation.DataSource;
import com.czk.hope.datasource.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import sun.util.calendar.LocalGregorianCalendar;

import java.lang.reflect.Method;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:40
 */
@Aspect
@Component
@ConditionalOnProperty(prefix = "gt.maxzhao.boot", name = "multiDatasourceOpen", havingValue = "true")
@Slf4j
public class DataSourceAspect {

    @Pointcut("@annotation(com.czk.hope.aop.annotation.DataSource)")
    public void dataSourcePointcut() {}

    @Around("dataSourcePointcut()")
    public Object dataSourceAround(ProceedingJoinPoint point) throws Throwable {
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        Object[] args = point.getArgs();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource != null) {
            DynamicDataSource.setDataSourceDbName(dataSource.name());
            log.info("设置数据源为：" + dataSource.name());
        } else {
            DynamicDataSource.setDataSourceDbName("main");
            log.info("设置数据源为：默认  -->  main");
        }
        try {
            return point.proceed(args);
        } finally {
            log.info("清空数据源信息！");
            DynamicDataSource.clearDataSourceDbName();
        }
    }

}
