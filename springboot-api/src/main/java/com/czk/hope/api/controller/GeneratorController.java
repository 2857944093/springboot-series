package com.czk.hope.api.controller;

import com.czk.hope.api.service.GeneratorService;
import com.czk.hope.entity.repository.UserRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/25 15:40
 */

@RestController
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @RequestMapping("get/code")
    public void  getCode(HttpServletResponse response) throws IOException {
        byte[] data = generatorService.generatorCode();

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"czk.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
