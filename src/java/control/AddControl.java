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
@WebServlet(name = "AddControl", urlPatterns = {"/add"})
public class AddControl extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        String pprice = request.getParameter("price");
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        String pquantity = request.getParameter("p_quantity");
        String pcategory = request.getParameter("category");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();
        if (pprice != null && !pprice.isEmpty()) {
            try {
                double priceValue = Double.parseDouble(pprice);
                    if (priceValue <= 0) {
                        request.setAttribute("priceError", "Price must be greater than 0");
                        request.getRequestDispatcher("manager").forward(request, response);
                        return; // Dừng xử lý tiếp theo
                    }
                }catch (NumberFormatException e) {
                    request.setAttribute("priceError", "Price must be a number");
                    request.getRequestDispatcher("manager").forward(request, response);
                    return; // Dừng xử lý tiếp theo
                }
        }
        if (pquantity != null && !pquantity.isEmpty()) {
            try {
                int quantityValue = Integer.parseInt(pquantity);
                    if (quantityValue <= 0) {
                        request.setAttribute("qError", "Quantity must be greater than 0");
                        request.getRequestDispatcher("manager").forward(request, response);
                        return; // Dừng xử lý tiếp theo
                    }
                }catch (NumberFormatException e) {
                    request.setAttribute("qError", "Quantity must be a number");
                    request.getRequestDispatcher("manager").forward(request, response);
                    return; // Dừng xử lý tiếp theo
                }
        }
            // Dừng xử lý tiếp theo
            DAO dao = new DAO();
            dao.insertProduct(pname, pimage, pprice, ptitle, pdescription, pquantity ,pcategory, sid);
            response.sendRedirect("manager");
            // Nếu pprice không có giá trị, bạn có thể xử lý một cách khác tùy thuộc vào trường hợp
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
