package com.czk.hope.api.controller.blockchain;

import com.czk.hope.blockchain.eth.EthConstants;
import com.czk.hope.blockchain.eth.EthUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/1/10 15:20
 */
@RestController
@RequestMapping(path = "/eth")
public class EthController {

    @RequestMapping("/create")
    public ResponseEntity createAccount(HttpServletRequest request, @RequestParam String password) {
        String filePath = EthUtils.createAccount(password);
        File file = new File(EthConstants.privateKeyJsonFilePath + filePath);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                    .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
                    .body(resource);
    }

}
