/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author trinh
 */
public class Account {
    private int id;
    private String user;
    private String user_name;
    private String pass;
    private int isAdmin;

    public Account() {
    }

    public Account(int id, String user, String user_name, String pass, int isAdmin) {
        this.id = id;
        this.user = user;
        this.user_name = user_name;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + '}';
    }

   

    
}
