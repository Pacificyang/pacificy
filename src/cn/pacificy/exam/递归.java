package cn.pacificy.exam;

import java.io.File;

public class 递归 {
	
	/*
	 * File 
	 * 
	 * 递归：
	 * 	循环的操作，但是不知道循环多少次
	 * 
	 * 1、进入文件夹中，查看是否有子文件和子文件夹
	 * 2、如果有子文件，就直接删除。
	 * 		如果有子文件夹，那么进入子文件夹中，
	 * 
	 */
	public static void main(String[] args) {
		printJava(new File("E:\\develop\\mars_workspace"));
	}
	
	public static void printJava(File dir){	
		
		File[] files = dir.listFiles();
		
		if(files != null){
			for (File file : files) {
				if(file.isFile()){
					if(file.getName().endsWith(".java")){
						System.out.println(file.getName());
					}
				}else{
					printJava(file);
				}
			}
		}
	}
	
	
	//定义一个方法删除文件夹
	public static void deleteDir(File dir){
		
		File[] files = dir.listFiles();
		
		if(files != null){
			//清空文件夹中的所有子文件和子文件夹
			for (File file : files) {
				
				//如果是文件，调用删除文件的方法
				if(file.isFile()){
					file.delete();
				}else {
					
					//如果是文件夹，调用删除文件夹的方法删除
					deleteDir(file);
				}
			}
		}
		
		dir.delete();
	}
}
