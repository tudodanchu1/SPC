/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.adminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;


/**
 *
 * @author sun
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    private final adminDAO dao = new adminDAO();
    private Admin admin;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tentaikhoan = request.getParameter("tentaikhoan");
        String matkhau = request.getParameter("matkhau");
        admin = dao.check(tentaikhoan, matkhau);
        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("LOGIN_USER", admin);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/admin.jsp");
                rd.forward(request, response);
            }
         else {
            request.setAttribute("errorLogin", "Ten dang nhap hoac mat khau khong chinh xac");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }
}
