package cn.pacificy.net.net_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		//�������ն�Socket����
		DatagramSocket ds = new DatagramSocket(9999);
		//����������
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		//��������
		ds.receive(dp);
		//��������
		//��ȡ���Ͷ�IP����
		InetAddress address = dp.getAddress();
		//��ȡ����
		byte[] data = dp.getData();
		//��ȡ���ݵĳ���
		int length = dp.getLength();
		//�������
		System.out.println("sender ---> " + address.getHostName());
		System.out.println(new String(data,0,length));
		//�ͷ���Դ
		ds.close();
	}
}
