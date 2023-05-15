/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User;

import dao.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "UserUpdateController", urlPatterns = {"/UserUpdateController"})
public class UserUpdateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private userDAO userdao = new userDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Users user = userdao.details(id);
        request.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/User/userUpdate.jsp");
        rd.forward(request, response);
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
        String userID = request.getParameter("userID");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));                
        String fullname = request.getParameter("fullname");
        String pass = request.getParameter("pass");
        
        boolean validation = true;
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String regmail ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        boolean ktmail = request.getParameter("email").matches(regmail);
        boolean kt = request.getParameter("phone").matches(reg);
        if (kt == false) {
            validation = false;
            request.setAttribute("errorPhone", "Pls enter realnumber");
        }
        if (ktmail == false) {
            validation = false;
            request.setAttribute("errorEmail", "Pls enter email again");
        }
 
        if(validation){
             Users nu = new Users(userID, email, phone, fullname, pass);
             userdao.update(nu);
             List<Users> list = userdao.read();
             request.setAttribute("list", list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/User/userView.jsp");
            rd.forward(request, response);
             
        }else{
                        request.getRequestDispatcher("/view/admin/User/userUpdate.jsp").forward(request, response);

        }
    }

}

