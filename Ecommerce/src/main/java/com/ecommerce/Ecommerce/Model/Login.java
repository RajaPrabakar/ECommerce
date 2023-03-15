package com.ecommerce.Ecommerce.Model;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginId;

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
