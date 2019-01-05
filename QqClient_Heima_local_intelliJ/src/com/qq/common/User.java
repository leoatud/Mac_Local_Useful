package com.qq.common;

import java.io.Serializable;

/**
 * this is User class, pojo and object can be send
 */

public class User implements Serializable {

    private String userId;
    private String passwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
