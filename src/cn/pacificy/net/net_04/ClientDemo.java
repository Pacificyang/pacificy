package cn.pacificy.net.net_04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 * ʹ��TCPЭ�鷢������
		�������Ͷ�Socket���󣨴������ӣ�
		��ȡ���������
		��������
		�ͷ���Դ
		
	Socket(InetAddress address, int port) 
	Exception in thread "main" java.net.ConnectException: Connection refused: connect

 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		//�������Ͷ�Socket���󣨴������ӣ�
		Socket s = new Socket(InetAddress.getByName("itheima"),10086);
		//��ȡ���������
		OutputStream os = s.getOutputStream();
		//��������
		String str = "hello tcp,im comming!!!";
		os.write(str.getBytes());
		//�ͷ���Դ
		//os.close();
		s.close();
	}
}
