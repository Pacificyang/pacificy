package cn.pacificy.net.net_05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 	����ʹ��TCPЭ�鷢�����ݣ��������յ�������ת���ɴ�д����
 	
 	�ͻ��˷�������
 	����˽�������
 	�����ת������
 	����˷�������
 	�ͻ��˽�������
 	
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		//�����ͻ���Socket����
		Socket s = new Socket(InetAddress.getByName("itheima"),10010);
		//��ȡ���������
		OutputStream os = s.getOutputStream();
		//��������
		os.write("tcp,im comming again!!!".getBytes());

		
		//��ȡ����������
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len;//���ڴ洢��ȡ�����ֽڸ���
		//��������
		len = is.read(bys);
		//�������
		System.out.println(new String(bys,0,len));
		
		//�ͷ���Դ
		s.close();
		
	}
}
