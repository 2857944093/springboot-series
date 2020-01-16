package com.czk.hope.blockchain.eth;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigInteger;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/1/9 9:53
 * ETH配置类
 */
public class EthConstants {

    /*----- 自己维护一个nonce -----*/
    public static BigInteger nonce = new BigInteger("0");

    /*---- 建立web3j ----*/
    public static Web3j web3j = Web3j.build(new HttpService("https://mainnet.infura.io/v3/38da986f5faf4fbbbc4c62dc0be91ceb"));

    /*---- 转账的手续费 ----*/
    public static BigInteger gasPrice = Convert.toWei("10", Convert.Unit.GWEI).toBigInteger();
    public static BigInteger gasLimit = Convert.toWei("45000", Convert.Unit.WEI).toBigInteger();

    /*---- 合约地址 ----*/
    public static String contractAccount = "0xdac17f958d2ee523a2206206994597c13d831ec7";

    /*---- 汇手续费的地址 ----*/
    public static String serviceCharge = "0xFD688E25d75b8eBe5FD2931d8B31fF5c74500339";

    /*---- 汇手续费的私钥 ----*/
    public static String serviceChargePrivateKey = "44B0C6B647A03D8845384648B195956151C1B5A403FE015FF6898BB8814BB451";

    /*---- 代币的位数 ----*/
    public static Integer decimals = 6;

    /*---- 代币归集的地址 ----*/
    public static String ercToAddress = "0x702cb43913cf0ba7db81be716d7462bc9faad1a8";

    /*---- 获取私钥的URL ----*/
    public static String getPrivateKeyUrl = "http://103.208.34.179:8089/collection/getprivatekey";

    /*---- 存放json私钥文件地址 ----*/
    public static String privateKeyJsonFilePath = "E:\\czk\\ethwallet\\";
}
