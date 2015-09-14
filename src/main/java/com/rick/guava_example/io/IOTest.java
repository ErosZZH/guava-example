package com.rick.guava_example.io;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.io.Resources;

public class IOTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//asCharSource
		String filePath = IOTest.class.getClassLoader().getResource("test.txt").getPath();
		File file = new File(filePath);
		ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
		for(String line: lines) {
			System.out.println(line);
		}
		
		String fileReaded = Files.asCharSource(file, Charsets.UTF_8).read();
		System.out.println(fileReaded);
		
		//asByteSource
		byte[] b = Files.asByteSource(file).read();
		String fileReaded1 = new String(b);
		System.out.println(fileReaded1);
		
		//asCharSink
		String filePath1 = IOTest.class.getClassLoader().getResource("test1.txt").getPath();
		File file1 = new File(filePath1);
		Files.asCharSink(file1, Charsets.UTF_8, FileWriteMode.APPEND).write("abc");
		
		//asByteSink
		String filePath2 = IOTest.class.getClassLoader().getResource("test2.txt").getPath();
		File file2 = new File(filePath2);
		String s = "123";
		Files.asByteSink(file2, FileWriteMode.APPEND).write(s.getBytes());
		
	}

}
