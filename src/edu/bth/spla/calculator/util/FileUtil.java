package edu.bth.spla.calculator.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class FileUtil {
	private static final String RESOURCE_DIR = "/edu/bth/spla/calculator/resources/";
	
	public static File createFile(String sourceDir, String packageName ,String className, String extension){
		StringBuilder classPath = new StringBuilder(sourceDir);
		classPath.append("/");
		if(!packageName.trim().equals("")){
			classPath.append(packageName.replace('.', '/')).append("/");
		}
		File file = new File(classPath.toString());
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
		classPath.append(className).append(".").append(extension);
		return new File(classPath.toString());
	}
	
	public static void writeFile(File classFile, String classContents) throws IOException{
		FileWriter fileWriter = new FileWriter(classFile);
		fileWriter.write(classContents);
		fileWriter.close();
	}
	
	public static void main(String[] args) throws Exception{
		FileUtil.copyResource("apple.jpg", "D:/test/apple.jpg");
		
	}
	
	public static void copyResource(String resourceName, String dest) throws Exception{
		StringBuilder sb = new StringBuilder(RESOURCE_DIR);
		sb.append(resourceName);
		URL url = FileUtil.class.getResource(sb.toString());
		sb= new StringBuilder(dest).append(File.separator).append(resourceName);
		InputStream is = url.openStream();
		byte[] bytes = new byte[1024];
		FileOutputStream fos = new FileOutputStream(sb.toString());
		int numRead = 0;
        while ((numRead = is.read(bytes)) > -1) {
        	fos.write(bytes, 0, numRead);
        }
        fos.close();
        is.close();
	}
}