package cn.pacificy.net.net_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * ʹ��UDPЭ�鷢������
		�������Ͷ�Socket����
		�������ݲ����
		��������
		�ͷ���Դ
 * 
 * DatagramSocket:�����ʾ�������ͺͽ�������,����UDPЭ���
 * 
 * DatagramSocket() ������Socket�����������˿ں�
 * DatagramSocket(int port) ������Socket����ָ���˿ں�
 */
public class SendDemo {
	public static void main(String[] args) throws IOException  {
		//�������Ͷ�Socket����
		DatagramSocket ds = new DatagramSocket();
		//�������ݲ����
		/*
		 * DatagramPacket :�����ʾ���ݱ���
		 * ���� byte[]
		 * �豸�ĵ�ַ ip
		 * ���̵ĵ�ַ  �˿ں�
		   DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
		 */
		
		String s = "hello udp,im comming!";
		byte[] bys = s.getBytes();
		int length = bys.length;
		InetAddress address = InetAddress.getByName("itheima");//���͸���ǰ�豸
		int port = 8888;
		//���
		DatagramPacket dp = new DatagramPacket(bys,length,address,port);
		//��������
		ds.send(dp);
		//�ͷ���Դ
		ds.close();
	}
}
