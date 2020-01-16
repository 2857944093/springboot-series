package com.czk.hope.api.controller.blockchain;

import com.czk.hope.blockchain.eth.EthConstants;
import com.czk.hope.blockchain.eth.EthUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/1/10 15:20
 */
@RestController("/eth")
public class EthController {

    @RequestMapping("/create/account")
    public void createAccount(HttpServletRequest request, @RequestParam String password) {
        String filePath = EthUtils.createAccount(password);
        File file = new File(EthConstants.contractAccount + filePath);
        byte[] body = null;
        try {
            InputStream is = new FileInputStream(file);
            body = new byte[is.available()];
            is.read(body);
            HttpHeaders httpHeaders = new  HttpHeaders();
            httpHeaders.add("Content-Disposition", "attchement;filename=" + file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
