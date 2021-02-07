package cn.pacificy.ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ping {
    public boolean ping(String ip){
        //ping
        Runtime runtime =Runtime.getRuntime(); // ��ȡ��ǰ��������н�����
        Process process = null; //�������������
        String line = null; //��������Ϣ
        InputStream is = null; //������
        InputStreamReader isr = null;// �ֽ���
        BufferedReader br = null;
        //String ip = "www.baidu.com";
        boolean res = false;// ���
        try {
            process =runtime.exec("ping " + ip); // PING

            is =process.getInputStream(); // ʵ����������
            isr = new InputStreamReader(is);// ��������ת�����ֽ���
            br = new BufferedReader(isr);// ���ֽ��ж�ȡ�ı�
            while ((line= br.readLine()) != null) {
                if(line.contains("TTL")) {
                    res= true;
                    break;
                }
            }
            is.close();
            isr.close();
            br.close();
            if (res){
                System.out.println("pingͨ  ..."+ip);

            } else{
                System.out.println("ping��ͨ..."+ip);
            }
            return res;
        } catch (IOException e) {
            System.out.println(e);
            runtime.exit(1);
        }
        return res;
    }
}
