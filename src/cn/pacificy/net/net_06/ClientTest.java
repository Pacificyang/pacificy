package cn.pacificy.net.net_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 模拟用户登录
 */
public class ClientTest {
	public static void main(String[] args) throws  IOException  {
		//创建客户端Socket对象
		//Socket s = new Socket(InetAddress.getByName("itheima"),8888);
		Socket s = new Socket("itheima",8888);
		
		//获取用户名和密码
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名:");
		String username = br.readLine();
		System.out.println("请输入密码:");
		String password = br.readLine();
		
		
		//获取输出流对象
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//写出数据
		out.println(username);
		out.println(password);
		
		//获取输入流对象
		BufferedReader serverBr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//获取服务器返回的数据
		String result = serverBr.readLine();
		System.out.println(result);
		//释放资源
		s.close();
	}
}
