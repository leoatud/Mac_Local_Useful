package com.qq.server.model;

import com.qq.common.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * server and client thread
 */

public class ServerConnectClientThread extends Thread{

    Socket s;

    public ServerConnectClientThread(Socket s){
        this.s = s;
    }

    public void run(){

        while(true){
            //receive client information

            try{
                ObjectInputStream ois = new ObjectInputStream(this.s.getInputStream());
                Message ms = (Message)ois.readObject();

                System.out.println("send message " + ms.getSender() + " To "+ ms.getReceiver()
                                    +" say "+ms.getContent());

                ServerConnectClientThread sccThread = ManageClientThread.getClientThread(ms.getReceiver());
                ObjectOutputStream oos = new ObjectOutputStream(sccThread.s.getOutputStream());
                oos.writeObject(ms);

            } catch(Exception e){
                e.printStackTrace();
            }





        }


    }
}
