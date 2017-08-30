package com.goodsoft.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by ASUS on 2017/7/13.
 */
public class ReadQRCode {
    public static void main(String[] arg) throws NotFoundException {
        MultiFormatReader formatReader = new MultiFormatReader();
        File file = new File("D:/code/img.png");
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        Result result = formatReader.decode(binaryBitmap, hints);
        System.out.println("解析结果：" + result.toString());
        System.out.println("二维码格式类型：" + result.getBarcodeFormat());
        System.out.println("二维码文本内容：" + result.getText());
    }
}
