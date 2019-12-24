package com.czk.hope.datasource.config;

import com.czk.hope.datasource.properties.DruidProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 17:21
 */
@Configuration
@ConfigurationProperties(prefix = "gt.maxzhao.boot")
@Data
@Slf4j
public class MultiDataSource {
    public MultiDataSource() {
        log.info("加载多数据源配置信息  -->  {}", "gt.maxzhao.boot.datasource");
    }
    /**
     * 多个数据源
     */
    private List<DruidProperties> datasource;
}
