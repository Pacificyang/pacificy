package com.itheima_03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * UDP协议收发数据的注意事项：
 * 		端口号错误，数据可以正常发出，不会出现异常，但是收不到数据
 * 		Exception in thread "main" java.net.BindException: Address already in use: Cannot bind
 * 			端口号已经绑定了
 */
public class SendDemo {
	public static void main(String[] args) throws IOException {
		// 创建发送端Socket对象
		DatagramSocket ds = new DatagramSocket();
		// 创建包对象
		byte[] bys = "hello udp,im comming again!!!".getBytes();
		DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("itheima"), 9999);
		// 发送数据
		ds.send(dp);
		// 释放资源
		ds.close();
	}
}
