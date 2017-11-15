package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class TestRead {
	public static void main(String[] args) {
		try {
			MultiFormatReader reader=new MultiFormatReader();
			File f=new File("/home/yyc/ͼƬ/img.png");
			BufferedImage image=ImageIO.read(f);
			BinaryBitmap bb=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			HashMap map =new HashMap();
			map.put(EncodeHintType.CHARACTER_SET, "utf-8");
			Result result = reader.decode(bb,map);
			System.out.println("���������"+result.toString());
			System.out.println("��ά���ʽ���ͣ�"+result.getBarcodeFormat());
			System.out.println("��ά���ı����ݣ�"+result.getText());
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
