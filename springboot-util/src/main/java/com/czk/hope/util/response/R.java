package com.czk.hope.util.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 16:29
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class R<T> {

    private Integer code;
    private String msg;
    private T data;


    public static R ok() {
        return ok(null);
    }

    public static <T> R ok(T data) {
        return success(0, "success", data);
    }

    public static R success(Integer code, String msg) {
        return success(code, msg, null);
    }

    public static <T> R success(Integer code, String msg, T data) {
        return build(code, msg, data);
    }

    public static R error() {
        return error(null);
    }

    public static <T> R error(T data) {
        return error(-1, "error", data);
    }

    public static R error(Integer code, String msg) {
        return error(code, msg, null);
    }

    public static <T> R error(Integer code, String msg, T data) {
        return build(code, msg, data);
    }

    public static <T> R build(Integer code, String msg, T data) {
        R r = new R();
        r.code = code;
        r.msg = msg;
        r.data = data;
        return r;
    }

}
