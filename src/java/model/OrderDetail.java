/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT1174
 */
public class OrderDetail {
    private int od_id;
    private int order_id;
    private String name;
    private String image;
    private double price;
    private int quantity;

    public OrderDetail(int od_id, int order_id, String name, String image, double price, int quantity) {
        this.od_id = od_id;
        this.order_id = order_id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetail() {
    }

    public int getOd_id() {
        return od_id;
    }

    public void setOd_id(int od_id) {
        this.od_id = od_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "od_id=" + od_id + ", order_id=" + order_id + ", name=" + name + ", image=" + image + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
}
