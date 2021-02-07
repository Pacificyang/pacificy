import cn.pacificy.jdbc.datasource.DruidDemo1;
import cn.pacificy.ping.Jdbc;
import cn.pacificy.ping.Ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class my {

    public static void main(String[] args) {

        System.out.println("helko");

        Jdbc jdbc = new Jdbc();

        List<String> ips=jdbc.getips();


        Ping myPing = new Ping();

        for(String ip:ips){
            myPing.ping(ip);
        }


    }

}
