/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author FPT1174
 */
public class Order{

    private int orderId;
    private int uid;
    private double price;
    private Date date;
    private Account ac;

    public Order() {
    }

    

    public Order(int orderId, int uid, double price, Date date, Account ac) {
        this.orderId = orderId;
        this.uid = uid;
        this.price = price;
        this.date = date;
        this.ac = ac;
    }

    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAc() {
        return ac;
    }

    public void setAc(Account ac) {
        this.ac = ac;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", uid=" + uid + ", price=" + price + ", date=" + date + ", acName=" + ac.getUser_name() + ",acEmail=" +ac.getUser() +'}';
    }


    
    
}
