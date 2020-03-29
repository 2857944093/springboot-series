package com.czk.hope.blockchain.btc;

import lombok.extern.slf4j.Slf4j;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.wallet.Wallet;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/1/16 15:28
 * btc工具类
 */
@Component
@Slf4j
public class BtcUtils {
    String apiKey = "44fb-61fc-c079-f775";
    public static void main(String[] args) {
        NetworkParameters parameters = MainNetParams.get();
        ECKey key = new ECKey();
        System.out.println(key.getPrivKey());
        System.out.println(key.getPrivateKeyAsHex());
        System.out.println(key.getPublicKeyAsHex());
        System.out.println(key.toAddress(parameters));
        final File walletFile = new File("test.wallet");
        Wallet wallet = new Wallet(parameters);

        wallet.addKey(new ECKey());
        try {
            wallet.saveToFile(walletFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}