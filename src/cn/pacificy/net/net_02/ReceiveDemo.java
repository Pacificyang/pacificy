package cn.pacificy.net.net_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * ʹ��UDPЭ���������
		�������ն�Socket����
		��������
		��������
		�������
		�ͷ���Դ

 */
public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		//�������ն�Socket����
		DatagramSocket ds = new DatagramSocket(8888);
		//��������
		//DatagramPacket(byte[] buf, int length) 
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys,bys.length);
				
		System.out.println(1);
		ds.receive(dp);//����
		System.out.println(2);
		
		//��������
		//InetAddress getAddress() : ��ȡ���Ͷ˵�IP����
		InetAddress address = dp.getAddress();
		//byte[] getData()  ����ȡ���յ������ݣ�Ҳ����ֱ��ʹ�ô���������ʱ������
		byte[] data = dp.getData();
		//int getLength()  ����ȡ�����յ����ݵĳ���
		int length = dp.getLength();
		
		//�������
		System.out.println("sender ---> " + address.getHostAddress());
		//System.out.println(new String(data,0,length));
		System.out.println(new String(bys,0,length));
		//�ͷ���Դ
		ds.close();

	}
}
