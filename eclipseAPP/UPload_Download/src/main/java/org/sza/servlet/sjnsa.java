package org.sza.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

public class sjnsa {
	
	public static void main(String[] args) {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			// 111.txt中存储helloworld世界你好
			// 10个英文10个字节 + 4个中文每个中文3个字节12个字节 = 22
			inputStream = new FileInputStream("E:\\111.txt");
			outputStream = new FileOutputStream("E:\\112.txt");
			
			int readlength;//读入到缓冲区的字节数，返回实际读取的字节数
			byte[] buf = new byte[8];
			
			
			while ( (readlength = inputStream.read(buf)) != -1) {
				outputStream.write(buf,0,readlength);
			}
			
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				outputStream.close();
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
