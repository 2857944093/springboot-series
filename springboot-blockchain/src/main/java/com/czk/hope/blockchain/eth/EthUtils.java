package com.czk.hope.blockchain.eth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.*;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/1/16 14:03
 * eth工具类
 * TODO 测试
 */
@Component
@Slf4j
public class EthUtils {

    /**
     * 创建地址生成eth地址: json文件
     *
     * @param password json文件的密码
     * @return 路径
     */
    public static String createAccount(String password) {
        String walletFile = null;
        try {
            walletFile = WalletUtils.generateNewWalletFile(password, new File(EthConstants.privateKeyJsonFilePath));
            log.info("walletFile: {}", walletFile);
        } catch (CipherException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return walletFile;
    }

    /**
     * 获取nonce
     *
     * @param address 地址
     * @return 交易的nonce值
     */
    public static BigInteger getNonce(String address) {
        try {
            EthGetTransactionCount ethGetTransactionCount = EthConstants.web3j.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();
            if (ethGetTransactionCount == null) {
                return null;
            }
            log.info("nonce: {}", ethGetTransactionCount.getTransactionCount());
            return ethGetTransactionCount.getTransactionCount();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取eth余额
     *
     * @param address 地址
     * @return eth余额
     */
    public static BigDecimal getBalance(String address) {
        try {
            EthGetBalance ethGetBalance = EthConstants.web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).sendAsync().get();
            if (ethGetBalance == null) {
                return null;
            }
            BigDecimal balance = Convert.fromWei(new BigDecimal(ethGetBalance.getBalance()), Convert.Unit.ETHER);
            log.info("ETH Balance: {}", balance);
            return balance;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取erc20代币余额
     *
     * @param address 地址
     * @param contractAddress 合约地址
     * @return 代币余额
     */
    public static BigDecimal getTokenBalance(String address, String contractAddress) {
        //指定调用合约方法
        Function function = balanceOfFunction(address);

        String data = FunctionEncoder.encode(function);

        String send = null;
        try {
            send = EthConstants.web3j.ethCall(Transaction.createEthCallTransaction(address, contractAddress, data), DefaultBlockParameterName.LATEST).send().getResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BigDecimal erc20Balance = EthConvertValue(send);
        log.info("erc20Balance: {}", erc20Balance);
        return erc20Balance;
    }

    /**
     * 发送eth
     *
     * @param fromAddress 发送者地址
     * @param privateKey  发送者私钥
     * @param toAddress   接收方地址
     * @param value       交易金额
     * @return 交易的hash值
     */
    public static String transferEth(String fromAddress, String privateKey, String toAddress, BigDecimal value) {
        Credentials credentials = Credentials.create(privateKey);
        BigInteger ethValue = Convert.toWei(value, Convert.Unit.ETHER).toBigInteger();
        BigInteger nonce = getNonce(fromAddress);
        RawTransaction rawTransaction = RawTransaction.createEtherTransaction(nonce, EthConstants.gasPrice, EthConstants.gasLimit, toAddress, ethValue);
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexString = Numeric.toHexString(signMessage);
        EthSendTransaction ethSendTransaction = null;
        try {
            ethSendTransaction = EthConstants.web3j.ethSendRawTransaction(hexString).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String hash = null;
        if (ethSendTransaction.hasError()) {
            log.info("transfer error: {}", ethSendTransaction.getError().getMessage());
        } else {
            hash = ethSendTransaction.getTransactionHash();
            log.info("transfer success: {}", hash);
        }
        return hash;
    }

    /**
     * 发送代币
     *
     * @param fromAddress 发送方地址
     * @param privateKey 发送方私钥
     * @param toAddress 接收方地址
     * @param contractAddress 合约地址
     * @param value 发送金额
     * @return 交易的hash值
     */
    public static String transferToken(String fromAddress, String privateKey, String toAddress, String contractAddress, BigDecimal value) {
        Credentials credentials = Credentials.create(privateKey);
        BigInteger nonce = getNonce(fromAddress);
        Function function = transferFunction(fromAddress, valueConvertEth(value));
        String encode = FunctionEncoder.encode(function);
        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, EthConstants.gasPrice, EthConstants.gasLimit, contractAddress, encode);
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexString = Numeric.toHexString(signMessage);
        EthSendTransaction ethSendTransaction = null;
        try {
            ethSendTransaction = EthConstants.web3j.ethSendRawTransaction(hexString).sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String hash = null;
        if (ethSendTransaction.hasError()) {
            log.info("transfer error: {}", ethSendTransaction.getError().getMessage());
        } else {
            hash = ethSendTransaction.getTransactionHash();
            log.info("transfer success: {}", hash);
        }
        return hash;
    }

    /**
     * eth金额转交易金额
     *
     * @param value eth金额
     * @return
     */
    private static BigDecimal EthConvertValue(String value) {
        String s = new BigInteger(value.substring(2), 16).toString();
        int decimals = EthConstants.decimals;
        long count = 1L;
        for (int i = 0; i < decimals; i++) {
            count = count * 10L;
        }
        return new BigDecimal(s).divide(new BigDecimal(count), EthConstants.decimals, RoundingMode.HALF_DOWN);
    }

    /**
     * 交易金额转代币金额
     *
     * @param value 初始金额
     * @return 转换后的金额
     */
    private static BigInteger valueConvertEth(BigDecimal value) {

        int decimals = EthConstants.decimals;
        long count = 1L;
        for (int i = 0; i < decimals; i++) {
            count = count * 10L;
        }
        return value.multiply(new BigDecimal(count)).toBigInteger();
    }

    /**
     * 调用合约方法: 获取余额
     *
     * @param address
     * @return
     */
    private static Function balanceOfFunction(String address) {
        return new Function(
                "balanceOf",
                Arrays.asList(new Address(address)),
                Arrays.asList(new TypeReference<Uint256>() {
                })
        );
    }

    /**
     * 调用合约方法: 转账
     *
     * @param address
     * @return
     */
    private static Function transferFunction(String address, BigInteger value) {
        return new Function(
                "transfer",
                Arrays.asList(new Address(address), new Uint256(value)),
                Arrays.asList(new TypeReference<Uint256>() {
                })
        );
    }

}