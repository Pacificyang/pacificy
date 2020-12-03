package cn.pacificy.net.net_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException {
		//创建接收端Socket对象
		DatagramSocket ds = new DatagramSocket(9999);
		//创建包对象
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys, bys.length);
		//接收数据
		ds.receive(dp);
		//解析数据
		//获取发送端IP对象
		InetAddress address = dp.getAddress();
		//获取数据
		byte[] data = dp.getData();
		//获取数据的长度
		int length = dp.getLength();
		//输出数据
		System.out.println("sender ---> " + address.getHostName());
		System.out.println(new String(data,0,length));
		//释放资源
		ds.close();
	}
}
