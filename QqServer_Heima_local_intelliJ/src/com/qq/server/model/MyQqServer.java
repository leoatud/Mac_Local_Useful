package com.qq.server.model;

import com.qq.common.Message;
import com.qq.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * this is QQ server, for here to wait for other clients to connect
 *
 */

public class MyQqServer {


    public MyQqServer(){

        System.out.println("server start listening");

        try{
            //port 9999 listen
            ServerSocket ss = new ServerSocket(9999);
            //wait for connection
            while(true){
                Socket s = ss.accept();
                //receive using stream bufferReader
//            BufferedReader br = new BufferedReader((
//                    new InputStreamReader(s.getInputStream())
//                    ));
//            String info = br.readLine();
                /**
                 * change to object stream
                 */
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                User u = (User)ois.readObject();
                Message ms = new Message();
                System.out.println("Server received user name: " + u.getUserId() + " password:" + u.getPasswd());
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

                if(u.getPasswd().equals("123456")){
                    //login successful
                    ms.setMesType("1");
                    oos.writeObject(ms);

                    //add single thread here
                    ServerConnectClientThread scct = new ServerConnectClientThread(s);
                    ManageClientThread.addClientThread(u.getUserId(), scct);
                    //thread start
                    scct.start();


                }else{
                    ms.setMesType("2");
                    oos.writeObject(ms);
                    s.close();
                }

            }


        } catch(Exception e){
            e.printStackTrace();
        } finally{

        }
    }
}
