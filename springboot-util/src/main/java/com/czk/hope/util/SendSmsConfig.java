package com.czk.hope.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/1/16 13:30
 */
@Component
@ConfigurationProperties(prefix = "alibaba.sendsms")
@Data
public class SendSmsConfig {

    private String AccessKeyID;
    private String AccessKeySecret;
    /*模板编号*/
    private String TemplateCode;
    /*模板签名*/
    private String SignName;
}
