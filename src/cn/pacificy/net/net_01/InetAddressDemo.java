package cn.pacificy.net.net_01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress:�����ʾ������Э�� (IP) ��ַ�� 
 * 
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException   {
		//static InetAddress getByName(String host) 
		 //InetAddress address = InetAddress.getByName("itheima");
		InetAddress address = InetAddress.getByName("192.168.1.107");//ip��ַ��Ψһ��
	
		//System.out.println(address);//itheima/192.168.1.107 ipconfig
		
		String hostAddress = address.getHostAddress();//192.168.1.107 ����IP��ַ
		String hostName = address.getHostName();//itheima	����������
		
		System.out.println(hostAddress);
		System.out.println(hostName);


	}
}
