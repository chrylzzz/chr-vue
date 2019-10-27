package com.chryl.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chryl on 2019/10/26.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -5215907957697355085L;


    private String id;

    private String userName;

    private String userPassword;

    private Date userDate;

    public User() {
    }

    public User(String id, String userName, String userPassword, Date userDate) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userDate = userDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }
}
