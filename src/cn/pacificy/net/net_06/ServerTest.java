package cn.pacificy.net.net_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		//������������Socket����
		ServerSocket ss = new ServerSocket(8888);
		//����
		Socket s = ss.accept();
		//��ȡ����������
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//��ȡ�û���������
		String username = br.readLine();
		String password = br.readLine();
		//�ж��û����������Ƿ���ȷ
		boolean flag = false;
		if("itheima".equals(username) && "123456".equals(password)) {
			flag = true;
		}
		//��ȡ���������
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		//�����ж���Ϣ
		if(flag) {
			out.println("��½�ɹ�");
		}
		else {
			out.println("��½ʧ��");
		}
		//�ͷ���Դ
		s.close();
		//ss.close();//������һ�㲻�ر�
	}
}
