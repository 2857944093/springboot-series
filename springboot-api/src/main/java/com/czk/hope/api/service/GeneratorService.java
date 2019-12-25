package com.czk.hope.api.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: ChenZK
 * @Create: 2019/12/25 16:15
 **/
public interface GeneratorService {

    List<Map<String, String>> listTable();

    List<Map<String, String>> queryTable(String tableName);

    byte[] generatorCode();
}
