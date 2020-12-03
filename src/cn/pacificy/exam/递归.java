package cn.pacificy.exam;

import java.io.File;

public class �ݹ� {
	
	/*
	 * File 
	 * 
	 * �ݹ飺
	 * 	ѭ���Ĳ��������ǲ�֪��ѭ�����ٴ�
	 * 
	 * 1�������ļ����У��鿴�Ƿ������ļ������ļ���
	 * 2����������ļ�����ֱ��ɾ����
	 * 		��������ļ��У���ô�������ļ����У�
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
	
	
	//����һ������ɾ���ļ���
	public static void deleteDir(File dir){
		
		File[] files = dir.listFiles();
		
		if(files != null){
			//����ļ����е��������ļ������ļ���
			for (File file : files) {
				
				//������ļ�������ɾ���ļ��ķ���
				if(file.isFile()){
					file.delete();
				}else {
					
					//������ļ��У�����ɾ���ļ��еķ���ɾ��
					deleteDir(file);
				}
			}
		}
		
		dir.delete();
	}
}
