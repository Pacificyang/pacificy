package cn.pacificy.net.net_05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 	需求：使用TCP协议发送数据，并将接收到的数据转换成大写返回
 	
 	客户端发出数据
 	服务端接收数据
 	服务端转换数据
 	服务端发出数据
 	客户端接收数据
 	
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		//创建客户端Socket对象
		Socket s = new Socket(InetAddress.getByName("itheima"),10010);
		//获取输出流对象
		OutputStream os = s.getOutputStream();
		//发出数据
		os.write("tcp,im comming again!!!".getBytes());

		
		//获取输入流对象
		InputStream is = s.getInputStream();
		byte[] bys = new byte[1024];
		int len;//用于存储读取到的字节个数
		//接收数据
		len = is.read(bys);
		//输出数据
		System.out.println(new String(bys,0,len));
		
		//释放资源
		s.close();
		
	}
}
