/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.User;

import dao.rollDAO;
import dao.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Roll;
import model.Users;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "UserCreateController", urlPatterns = {"/UserCreateController"})
public class UserCreateController extends HttpServlet {

    private  rollDAO rolldao = new rollDAO();
    private  userDAO userdao = new userDAO();

    public UserCreateController() {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/User/userCreate.jsp");
        rd.forward(request, response);
        
    }

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
        if (userdao.details(userID) != null) {
            validation = false;
            request.setAttribute("errorId", "ID already exist");
        }
 
        if(validation){
             Users nu = new Users(userID, email, phone, fullname, pass);
             userdao.create(nu);
             List<Users> list = userdao.read();
             request.setAttribute("list", list);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/User/userView.jsp");
            rd.forward(request, response);
             
        }else{
                        request.getRequestDispatcher("/view/admin/User/userCreate.jsp").forward(request, response);

        }
             
 
    }

}
