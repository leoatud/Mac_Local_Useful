package com.itheima.testBS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;

        try {
            socket = new Socket("www.baidu.com",80);
            is = socket.getInputStream();
            os = socket.getOutputStream();
            os.write("GET /subject/about/index.html HTTP/1.1\n".getBytes());
            os.write("HOST:www.baidu.com\n".getBytes());
            os.write("\n".getBytes());

            int i=is.read();
            while(i!=-1){
                System.out.print((char)i);
                i = is.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null!=is){
                is.close();
                is=null;
            }
            if(null!=os){
                os.close();
                os=null;
            }
            if(null!=socket){
                socket.close();
                socket=null;
            }

        }


    }
}
