package com.itheima_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * UDPЭ���շ����ݵ�ע�����
 * 		�˿ںŴ������ݿ���������������������쳣�������ղ�������
 * 		Exception in thread "main" java.net.BindException: Address already in use: Cannot bind
 * 			�˿ں��Ѿ�����
 */
public class SendDemo {
	public static void main(String[] args) throws IOException {
		// �������Ͷ�Socket����
		DatagramSocket ds = new DatagramSocket();
		// ����������
		byte[] bys = "hello udp,im comming again!!!".getBytes();
		DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("itheima"), 9999);
		// ��������
		ds.send(dp);
		// �ͷ���Դ
		ds.close();
	}
}
