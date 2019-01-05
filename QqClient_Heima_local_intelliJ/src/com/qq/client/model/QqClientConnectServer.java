package com.qq.client.model;

import com.qq.client.tools.ClientConnectServerThread;
import com.qq.client.tools.ManagerClientConnetServerThread;
import com.qq.common.Message;
import com.qq.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * test server connection
 */

public class QqClientConnectServer {

//    public QqClientConnectServer(){
//
//
//    }

 //once create only one, should change here later
    // can not be static
    public static Socket s;
    /**
     * send first time
     */
    public boolean sendLoginInfoToServer(Object o){

        boolean flag = false;
        try {
            s = new Socket("127.0.0.1", 9999);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(o);

            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Message ms = (Message) ois.readObject();

            /**
             *  login verification, create connection between client and server
             */
            if(ms.getMesType().equals("1")) {
                ClientConnectServerThread ccst = new ClientConnectServerThread(s);
                ccst.start();
                ManagerClientConnetServerThread.addClientConnectServerThread(((User) o).getUserId(), ccst);
                flag = true;
            } else{
                s.close();
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{

        }

        return flag;
    }





}
