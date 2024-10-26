package org.sza.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class sjnsa {
	
	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream("E:\\学习笔记\\Learningnote\\笔记\\Java基础.md");
			inputStream.read();
			BufferedInputStream
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
