package com.czk.hope.aop.aspect;

import com.czk.hope.aop.annotation.DataSource;
import com.czk.hope.aop.annotation.RedisCleanCache;
import com.czk.hope.util.redis.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:40
 */
@Aspect
@Component
public class RedisCacheAspect {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Pointcut("@annotation(com.czk.hope.aop.annotation.RedisJoinCache)")
    public void redisJoinCachePointcut() {
    }

    @Around("redisJoinCachePointcut()")
    public Object redisJoinCacheAround(ProceedingJoinPoint point) throws Throwable {

        //获取类路径
        String clazzName = point.getTarget().getClass().getName();
        //获取方法名
        String methodName = point.getSignature().getName();
        //参数
        Object[] args = point.getArgs();
        //获取方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        //数据源
        DataSource dataSource = method.getAnnotation(DataSource.class);
        String dbName;
        if (dataSource == null) {
            dbName = "main";
        } else {
            dbName = dataSource.name();
        }
        //获取key值
        String key = genKey(clazzName, methodName, dbName, args);
        //去缓存中查询
        String value = redisUtils.getMap(key);
        Object result = null;
        if (StringUtils.isBlank(value)) {
            //缓存中找不到,调用方法
            result = point.proceed(args);
            //序列化
            redisUtils.setMap(key, objectMapper.writeValueAsString(result));
        } else {
            //获取被代理的方法的类型
            Class returnType = method.getReturnType();
            //缓存中有，直接返回，反序列化
            result = objectMapper.readValue(value, returnType);
        }
        /*
            返回多个对象的处理
            Boolean isList = returnType.isAssignableFrom(List.class);
            if (isList) {
                Type temp = me.getGenericReturnType();
                Type[] types = ((ParameterizedType) temp).getActualTypeArguments();
                Class real = (Class) types[0];
            } */
        return result;
    }

    /**
     * 根据id删除缓存中的数据
     */
    @Pointcut("@annotation(com.czk.hope.aop.annotation.RedisCleanCache)")
    public void redisCleanCachePointCut() {
    }

    @Around("redisCleanCachePointCut()")
    public void redisDelHandler(ProceedingJoinPoint point) throws Throwable {
        //获取类路径
        String clazzName = point.getTarget().getClass().getName();
        //获取查询的方法名
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        RedisCleanCache redisCleanCache = method.getAnnotation(RedisCleanCache.class);
        DataSource dataSource = method.getAnnotation(DataSource.class);
        String dbName;
        if (dataSource == null) {
            dbName = "main";
        } else {
            dbName = dataSource.name();
        }
        String methodName = redisCleanCache.name();
        //获取参数
        Object[] args = point.getArgs();
        //获取key
        String key = genKey(clazzName, methodName, dbName, args);
        //查询该key是否存在
        String value = redisUtils.getMap(key);
        if (StringUtils.isBlank(value)) {
            //调用方法从数据库中删除数据
            point.proceed(args);
        } else {
            //根据key删除缓存中的数据
            redisUtils.delMap(key);
            //调用方法从数据库中删除数据
            point.proceed(args);
        }
    }

    /**
     * 生成唯一key
     *
     * @param clazzName
     * @param methodName
     * @param args
     * @return java.lang.String
     */
    protected String genKey(String clazzName, String methodName, String dbName, Object[] args) {
        StringBuilder sb = new StringBuilder(clazzName);
        sb.append(".");
        sb.append(methodName);
        sb.append(".");
        sb.append(dbName);
        sb.append(".");
        for (Object obj : args) {
            sb.append(obj.toString());
            sb.append(".");
        }
        return sb.toString();
    }
}
