/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author FPT1174
 */
public class Item {
    private Product product;
    private int quantity;
    private double i_price;

    public Item() {
    }

    public Item(Product product, int quantity, double i_price) {
        this.product = product;
        this.quantity = quantity;
        this.i_price = i_price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getI_price() {
        return i_price;
    }

    public void setI_price(double i_price) {
        this.i_price = i_price;
    }

   
}
