/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import model.Account;
import model.Category;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Item;
import model.Order;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author trinh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductBySellID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where sell_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where [name] like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getAllAcc() {
        List<Account> listA = new ArrayList<>();
        String query = "select * from Account where isAdmin=0";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listA.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return listA;
    }

    public Product getProductByID(int id) {
        String query = "select * from product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getLast() {
        String query = "select top 1 * from product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6), rs.getInt(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account login(String user, String pass) {
        String query = "select * from account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account register(String user, String user_name, String pass) {
        String query = "select * from account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from account\n"
                + "where [user] = ?\n";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account singup(String user, String user_name, String pass) {
        String query = "insert into account\n"
                + "values(?,?,?,0)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, user_name);
            ps.setString(3, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteuser(String uID) {
        String query = "delete from Account where uID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, uID);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void deleteProduct(String pid) {
        String query = "delete from product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(String name, String image, String price,
            String title, String description, String p_quantity, String category, int sid) {
        String query = "INSERT [dbo].[product] \n"
                + "([name], [image], [price], [title], [description],[p_quantity], [cateID], [sell_ID])\n"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, p_quantity);
            ps.setString(7, category);
            ps.setInt(8, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String image, String price,
            String title, String description, String p_quantity, String category, String pid) {
        String query = "update product\n"
                + "set [name] = ?,\n"
                + "[image] = ?,\n"
                + "price = ?,\n"
                + "title = ?,\n"
                + "[description] = ?,\n"
                + "p_quantity = ?,\n"
                + "cateID = ?\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, p_quantity);
            ps.setString(7, category);
            ps.setString(8, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Order> getAllOrder() {
        List<Order> listO = new ArrayList<>();
        String query = "select o.[uID], a.[user], a.[user_name], o.order_id, o.price, o.[date] from [order] o inner join Account a on o.[uID] = a.[uID]";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account ac = new Account();
                ac.setUser(rs.getString("user"));
                ac.setUser_name(rs.getString("user_name"));
                Order o = new Order();
                o.setUid(rs.getInt("uID"));
                o.setOrderId(rs.getInt("order_id"));
                o.setPrice(rs.getDouble("price"));
                o.setDate(rs.getDate("date"));
                o.setAc(ac);
                listO.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listO;
    }

    public List<OrderDetail> getAllByUID(int uid) {
        List<OrderDetail> listOd = new ArrayList<>();
        String query = "select od.od_id, od.order_id, od.name , od.image, od.price, od.quantity from [order] o inner join order_detail od on od.order_id= o.order_id where o.uID= ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                listOd.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getInt(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOd;
    }

    public void addOrder(Account u, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            // add order
            conn = new DBContext().getConnection();
            String sql = "INSERT into [order] ( uID, price, date) \n"
                    + "VALUES ( ?,?,? )";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, u.getId());
            stm.setDouble(2, cart.getTotalMoney());
            stm.setString(3, date);
            stm.executeUpdate();
            // lay id cua order vua add vao
            String sql1 = "Select top 1 order_id from [order] order by order_id desc";
            PreparedStatement stm1 = conn.prepareStatement(sql1);
            ResultSet rs = stm1.executeQuery();
            // aa vao bang OrderDetail
            if (rs.next()) {
                int oid = rs.getInt("order_id");
                for (Item i : cart.getItems()) {
                    String sql2 = "INSERT [order_detail] ( order_id, name, image, price, quantity) \n"
                            + "VALUES ( ?, ?, ?, ?, ?)";
                    PreparedStatement stm2 = conn.prepareStatement(sql2);
                    stm2.setInt(1, oid);
                    stm2.setString(2, i.getProduct().getName());
                    stm2.setString(3, i.getProduct().getImage());
                    stm2.setDouble(4, i.getI_price());
                    stm2.setInt(5, i.getQuantity());
                    stm2.executeUpdate();
                }
            }

            // cap nhat lai so luong san pham
            String sql3 = "update [product] \n"
                    + "set p_quantity = p_quantity-? \n"
                    + "where id =?";
            PreparedStatement stm3 = conn.prepareStatement(sql3);
            for (Item i : cart.getItems()) {
                stm3.setInt(1, i.getQuantity());
                stm3.setInt(2, i.getProduct().getId());
                stm3.executeUpdate();
            }
        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        DAO d = new DAO();
        List<Order> list = d.getAllOrder();
        for (Order student : list) {
            System.out.println(student.toString());
        }

    }
}
