package cn.pacificy.net.net_05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//创建服务端Socket对象
		ServerSocket ss = new ServerSocket(10010);
		//监听
		Socket s = ss.accept();
		//获取输入流对象
		InputStream is = s.getInputStream();
		//获取数据
		byte[] bys = new byte[1024];
		int len;//用于存储读取到的字节个数
		len = is.read(bys);
		String str = new String(bys,0,len);
		//输出数据
		System.out.println(str);
		//转换数据
		String upperStr = str.toUpperCase();
		//获取输出流对象
		OutputStream os = s.getOutputStream();
		//返回数据（发出数据）
		os.write(upperStr.getBytes());
		
		//释放资源
		s.close();
		//ss.close();//服务端一般不关闭
		
		
	}
}
