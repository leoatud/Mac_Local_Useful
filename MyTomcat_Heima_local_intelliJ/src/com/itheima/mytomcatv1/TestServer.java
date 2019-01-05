package com.itheima.mytomcatv1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

    public static String WEB_ROOT =System.getProperty("user.dir")+"/"+"WebContent";

    public static String url = "";

    public static void main(String[] args) throws Exception{
        System.out.println(WEB_ROOT);


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
}