package com.qq.client.model;


import com.qq.common.User;

/**
 * check the login
 */

public class QqClientUser {
    public boolean checkUser(User u) {
        return new QqClientConnectServer().sendLoginInfoToServer(u);
    }

}
