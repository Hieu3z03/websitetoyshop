/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author trinh
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {

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
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        Account a = dao.login(username, password);
        if (a == null) {
            request.setAttribute("mess", "Wrong user or pass");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else if(a.getIsAdmin()==1){
            session.setAttribute("acc", a);
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
        } else {
            session.setAttribute("acc", a);
            session.setMaxInactiveInterval(1000);
            request.getRequestDispatcher("home").forward(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        HttpSession session = request.getSession();
//       PrintWriter out = response.getWriter();
//       DAO d = new DAO();
//       
//       String user = request.getParameter("user");
//       String pass = request.getParameter("pass");
//       
//        if (d.login(user, pass)!=null) {
//            
//            session.setAttribute("account", d.login(user, pass));
//            request.getRequestDispatcher("home").forward(request, response);
//        }else{
//            String err = "Thong tin dang nhap sai";
//            request.setAttribute("mess", err);
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
