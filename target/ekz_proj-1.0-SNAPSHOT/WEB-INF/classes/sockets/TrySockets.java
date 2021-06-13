package com.example.classes.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class TrySockets {
    public static void main(String[] args) {
        InetAddress currentIP = null;
        InetAddress belstuIP = null;
        try {
            currentIP = InetAddress.getLocalHost();
            belstuIP = InetAddress.getByName("www.belstu.by");
            System.out.println("local:" + currentIP + ";\tbelstu:" + belstuIP);

            byte[] ip = { (byte)123, (byte)162, (byte)204, (byte)87 };
            InetAddress addr = InetAddress.getByAddress("Unknow", ip);
            System.out.println(addr.getHostName() + "-> cоединение:" + addr.isReachable(100));

            URL mygit = new URL("https://github.com/TehanovAnton");
            InputStreamReader instreamreader = new InputStreamReader(mygit.openStream());
            BufferedReader reader = new BufferedReader(instreamreader);
            String str = "";
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }

            URL url = new URL("https://github.com/TehanovAnton");
            URLConnection urlconn = url.openConnection();
            System.out.println(urlconn.getContentType() + "\n" + urlconn.getClass() + "\n" + urlconn.getContentLength());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
