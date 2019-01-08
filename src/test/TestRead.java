package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import utils.ConstString;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/**
 * @ClassName TestRead
 * @Description TODO 二维码图片的解析
 * @Author yinyicao
 * @DateTime 2019/1/8 09:11
 * @Blog http://www.cnblogs.com/hyyq/
 */
public class TestRead {
	public static void main(String[] args) {
		try {
			MultiFormatReader reader=new MultiFormatReader();
			File f=new File("image/img"+ConstString.FORMAT);
			BufferedImage image=ImageIO.read(f);
			BinaryBitmap bb=new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			HashMap map =new HashMap(1);
			map.put(DecodeHintType.CHARACTER_SET, ConstString.CHARSET);
			Result result = reader.decode(bb,map);
			System.out.println("解析结果："+result.toString());
			System.out.println("二维码格式类型："+result.getBarcodeFormat());
			System.out.println("二维码文本内容："+result.getText());
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
