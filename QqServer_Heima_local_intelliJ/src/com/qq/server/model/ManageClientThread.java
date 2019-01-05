package com.qq.server.model;

import java.util.HashMap;
/**
 * handling multi thread, each thread stored in hashmap
 *
 */

public class ManageClientThread {


    //put hashmap into static, only one manager
    public static HashMap hashMap = new HashMap<String, ServerConnectClientThread>();

    // add thread
    public static void addClientThread(String uid, ServerConnectClientThread ct){
        hashMap.put(uid, ct);
    }

    //get thread
    public static ServerConnectClientThread getClientThread(String uid){
        return (ServerConnectClientThread)hashMap.get(uid);
    }
}
