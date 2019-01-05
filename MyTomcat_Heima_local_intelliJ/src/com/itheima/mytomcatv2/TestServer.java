package com.itheima.mytomcatv2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TestServer {

    public static String WEB_ROOT =System.getProperty("user.dir")+"/"+"WebContent";

    public static String url = "";

    private static Map<String ,String> map = new HashMap<>();


    static{
        Properties prop = new Properties();
        String haha = WEB_ROOT + "/conf.properties";
         try {

            prop.load(new FileInputStream(haha));
            Set set = prop.keySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                String key = (String)iterator.next();
                String value = prop.getProperty(key);
                map.put(key,value);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println(map);
        System.out.println(WEB_ROOT);
    }
    public void maina(String[] args) throws Exception{
        //System.out.println(WEB_ROOT);
        System.out.println(map);


        ServerSocket serverSocket=null;
        Socket socket = null;
        InputStream is =null ;
        OutputStream os=null;

        try {
            serverSocket = new ServerSocket(8080);


            while (true) {
                socket = serverSocket.accept();
                is = socket.getInputStream();
                os = socket.getOutputStream();
                parset(is);
                sendStaticResource(os);


            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os!=null){
                os.close();
                os=null;
            }
            if(is!=null){
                is.close();
                is=null;
            }
            if(socket!=null){
                socket.close();
                socket=null;
            }
        }

    }

    private static void sendStaticResource(OutputStream os) {
        byte[] bytes = new byte[2048];
        FileInputStream fis = null;
        File file = null;
        try {
            file = new File(WEB_ROOT,url);
            if(file.exists()){
                os.write("HTTP/1.1 200 OK\n".getBytes());
                os.write("Server:apache-Coyote/1.1\n".getBytes());
                os.write("\n".getBytes());
                fis = new FileInputStream(file);
                int ch = fis.read(bytes);
                while(ch!=-1){
                    os.write(bytes,0,ch);
                    ch = fis.read(bytes);
                }
            } else{
                for(int i=0;i<10;i++)
                    System.out.println("404 404 404");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }



    }

    //get request part
    private static void parset(InputStream is) throws Exception{
        StringBuffer sb = new StringBuffer();
        byte[] buffer = new byte[2048];
        int i=-1;

        i=is.read(buffer);
        for(int j=0;j<i;j++){
            sb.append((char)buffer[j]);
        }
        System.out.println(sb);
        parseUrl(sb.toString());
    }

    private static void parseUrl(String sb) {
        int index1, index2;
        index1 = sb.indexOf(" ");
        if(index1!=-1){
            index2 = sb.indexOf(" ",index1+1);
            if(index2 > index1){
                url = sb.substring(index1+2,index2);
            }
        }
        System.out.println(url);
    }

    public static void sendDynamicResource(InputStream is, OutputStream os) throws Exception{
        os.write("".getBytes());
        os.write("".getBytes());
        os.write("".getBytes());

        if(map.containsKey(url)){
            String value = map.get(url);
            Class cl = Class.forName(value);
            Servlet servlet = (Servlet)cl.newInstance();
            servlet.init();
            servlet.Service(is,os);
        }

    }

}