package com.qq.client.tools;


import java.util.HashMap;

/**
 * manager of client to server thread, using hashMap
 */

public class ManagerClientConnetServerThread {

    private static HashMap hashMap = new HashMap<String, ClientConnectServerThread>();

    public static void addClientConnectServerThread(String qqID, ClientConnectServerThread ccst){
        hashMap.put(qqID,ccst);
    }

    public static ClientConnectServerThread getClientConnectServerThread(String qqID){
        return (ClientConnectServerThread)hashMap.get(qqID);
    }
}
