package cn.pacificy.net.net_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * ģ���û���¼
 */
public class ClientTest {
	public static void main(String[] args) throws  IOException  {
		//�����ͻ���Socket����
		//Socket s = new Socket(InetAddress.getByName("itheima"),8888);
		Socket s = new Socket("itheima",8888);
		
		//��ȡ�û���������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û���:");
		String username = br.readLine();
		System.out.println("����������:");
		String password = br.readLine();
		
		
		//��ȡ���������
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//д������
		out.println(username);
		out.println(password);
		
		//��ȡ����������
		BufferedReader serverBr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//��ȡ���������ص�����
		String result = serverBr.readLine();
		System.out.println(result);
		//�ͷ���Դ
		s.close();
	}
}
