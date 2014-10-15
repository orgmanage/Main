package com.orgmanager.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;



public class QRCodeGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		try{
			Hashtable<EncodeHintType,ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType,ErrorCorrectionLevel>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			new QRCodeGenerator().generateQrCode("232590", "kamal",hintMap);
			new QRCodeGenerator().readQRCode("C:\\Users\\232590\\Desktop\\232590_QR.png");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}


	}

	public void generateQrCode(String userId, String userName, Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap) throws IOException, WriterException{
		// Create the ByteMatrix for the QR-Code that encodes the given String
		String qrCodeText = userId+" : "+userName;
		String filePath = "C:\\Users\\232590\\Desktop\\"+userId+"_QR.png";
		int size = 125;
		String fileType = "png";
		File qrFile = new File(filePath);
		
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
		System.out.println("DONE");
	}
	
	public void  readQRCode(String filePath)
			throws FileNotFoundException, IOException, NotFoundException {
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
				new BufferedImageLuminanceSource(
						ImageIO.read(new FileInputStream(filePath)))));
		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
		System.out.println(qrCodeResult.getText());
	}

}
