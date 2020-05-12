package com.czk.hope.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @Author: Created by ChenZK
 * @Create: 2020/5/11 16:51
 * 二维码
 */
public class QRCode {
    private static final String QR_CODE_IMAGE_PATH = "E:\\czk\\";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        System.out.println(path);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    public static void main(String[]args) throws IOException, WriterException {
        generateQRCodeImage("https://www.chenzki.com", 350, 350, QR_CODE_IMAGE_PATH+"chenzki.png");
    }
}
