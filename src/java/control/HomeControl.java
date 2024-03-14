/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import model.Category;
import model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.Item;

/**
 *
 * @author trinh
 */
@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //b1: get data from dao
//        DAO dao = new DAO();
//        List<Product> list = dao.getAllProduct();
//        List<Category> listC = dao.getAllCategory();
//        Product last = dao.getLast();
//        //b2: set data to jsp
//        request.setAttribute("listP", list);
//        request.setAttribute("listCC", listC);
//        request.setAttribute("p", last);
//        request.getRequestDispatcher("Home.jsp").forward(request, response);
//        //404 -> url
        //500 -> jsp properties
        HttpSession session = request.getSession();
        Account u;
        if ((u = (Account) session.getAttribute("acc")) == null) {
            response.sendRedirect("Login.jsp");
        } else {
            String usercart = "cart" + u.getId();
            DAO dao = new DAO();
            List<Product> list = dao.getAllProduct();
            List<Category> listC = dao.getAllCategory();
            Product last = dao.getLast();
            Cookie[] arr = request.getCookies();
            String txt = "";
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals(usercart)) {
                        txt += o.getValue();
                    }
                }
            }
            Cart cart = new Cart(txt, list);
            List<Item> listItem = cart.getItems();

            int n;
            if (listItem != null) {
                n = listItem.size();
                //  request.getRequestDispatcher("myshop.jsp").forward(request, response);
            } else {
                n = 0;
            }

            request.setAttribute("size", n);
            request.setAttribute("listP", list);
            request.setAttribute("listCC", listC);
            request.setAttribute("p", last);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
//        

        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
            () {
        return "Short description";
        }// </editor-fold>

    }
