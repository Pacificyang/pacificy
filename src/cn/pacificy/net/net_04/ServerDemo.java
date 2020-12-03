package cn.pacificy.net.net_04;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ʹ��TCPЭ���������
 		�������ն�Socket����
 		������������
 		��ȡ����������
 		��ȡ����
 		�������
 		�ͷ���Դ
 		
 	ServerSocket�����նˣ������Socket
 	ServerSocket(int port) 
 	Socket accept() 
 
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException  {
		//�������ն�Socket����
		ServerSocket ss = new ServerSocket(10086);
 		//������������
		Socket s = ss.accept();
 		//��ȡ����������
		InputStream is = s.getInputStream();
 		//��ȡ����
		byte[] bys = new byte[1024];
		int len;//���ڴ洢�������ֽڸ���
		len = is.read(bys);
 		//�������
		InetAddress address = s.getInetAddress();
		System.out.println("client ---> " + address.getHostName());
		System.out.println(new String(bys,0,len));
 		//�ͷ���Դ
		s.close();
		//ss.close();
	}
}
