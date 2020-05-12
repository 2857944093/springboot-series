package com.czk.hope.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Random;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/1/15 14:19
 */
@Slf4j
@Component
public class SendSmsUtils {

    @Autowired
    private SendSmsConfig sendSmsConfig;

    public String getCode() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1000000));
    }

    @SuppressWarnings("unchecked")
    public void sendSms(String phone, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", sendSmsConfig.getAccessKeyID(), sendSmsConfig.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", sendSmsConfig.getSignName());
        request.putQueryParameter("TemplateCode", sendSmsConfig.getTemplateCode());
        request.putQueryParameter("TemplateParam", "{\"code\": " + code + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info("response: {}", response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SendSmsUtils sendSmsUtils = new SendSmsUtils();
        sendSmsUtils.sendSms("", "");
    }

}
