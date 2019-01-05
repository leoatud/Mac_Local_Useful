package com.qq.client.tools;

import com.qq.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.charset.MalformedInputException;

/**
 * client connect server thread, many to mant
 */

public class ClientConnectServerThread extends Thread {

    private Socket s;

    public ClientConnectServerThread(Socket s){
        this.s = s;
    }

    public void run(){
        while(true){
            // read mesg from server

            try {
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Message ms = (Message)ois.readObject();
                System.out.println("return message: " + ms.getSender() + ms.getSender() + ms.getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

}
