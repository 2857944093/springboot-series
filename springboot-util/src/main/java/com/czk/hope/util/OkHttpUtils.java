package com.czk.hope.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import okhttp3.*;

import java.io.IOException;
import java.util.Random;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/25 15:29
 */
public class OkHttpUtils {

    public static String get(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String post(String url, String params) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mediaType, params))
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
