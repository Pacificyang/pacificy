import cn.pacificy.jdbc.datasource.DruidDemo1;
import cn.pacificy.ping.Jdbc;
import cn.pacificy.ping.Ping;
import cn.pacificy.ping.SendSms;

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

        String alertmsg = "";
        Ping myPing = new Ping();
        SendSms mySms = new SendSms();

//        for(String ip:ips){
//            boolean  res = myPing.ping(ip);
//            if(res){
//
//                jdbc.setstatus(ip,"online");
//            }else{
//
//                jdbc.setstatus(ip,"offline");
//                alertmsg = alertmsg+ip+";";
//            }
//        }

        //send alertmsg
        if(alertmsg==""){

            mySms.send("none");

        }else{
            alertmsg = alertmsg;
            //sendAlert(alertmsg);
            mySms.send(alertmsg);
        }



    }

}
