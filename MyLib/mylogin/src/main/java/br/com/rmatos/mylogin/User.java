package br.com.rmatos.mylogin;

import java.io.Serializable;

/**
 * Created by renato on 27/01/17.
 */

public class User implements Serializable {
    public String Login;
    public User(String login){
        this.Login = login;
    }
}
