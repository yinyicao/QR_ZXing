package test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.HashMap;

import Utils.ConstString;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class TestZXing {

	public static void main(String[] args) throws UnsupportedEncodingException {
		int width=ConstString.WIDTH;
		int height=ConstString.HEIGHT;
		String format= ConstString.FORMAT;
		String contents=new String(ConstString.CONTENTS.getBytes(),ConstString.CHARSET);
		HashMap map=new HashMap(3);
		map.put(EncodeHintType.CHARACTER_SET, ConstString.CHARSET);
		//容错率
		map.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.Q);
		map.put(EncodeHintType.MARGIN, ConstString.MARGIN);
		try {
			BitMatrix bm = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height,map);
			Path file=new File("image/img."+format).toPath();
			MatrixToImageWriter.writeToPath(bm, format, file);
			System.out.println("生成二维码成功,请到："+file+"中查看！");
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
