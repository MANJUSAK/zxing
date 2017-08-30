package com.goodsoft.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Created by ASUS on 2017/7/13.
 */
public class CreateQRCode {
    public static void main(String[] arg) {

        int width = 300;
        int height = 300;
        String format = "png";
        String content = "http://www.myfreedata.com.cn:81";
        Path file = new File("D:/code/img.png").toPath();
        File folder = new File("D:/code");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 1);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
            System.out.println("二维码创建成功");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
