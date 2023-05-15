/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Employee;

import dao.ApartmentBlockDAO;
import dao.carDAO;
import dao.employeeDAO;
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
import model.Car;
import model.ApartmentBlock;
import model.Employee;
import model.Users;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "EmployeeCreateController", urlPatterns = {"/EmployeeCreateController"})
public class EmployeeCreateController extends HttpServlet {
    private  final  employeeDAO emdao = new employeeDAO();
    private final ApartmentBlockDAO adao = new ApartmentBlockDAO();
    private java.util.List<ApartmentBlock> listapartment = new ArrayList<>();
    private List<ApartmentBlock> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       listapartment = adao.read();
        request.setAttribute("listapartment", listapartment);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Employee/employeeCreate.jsp");
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
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String fullname = request.getParameter("fullname");
        ApartmentBlock a = new ApartmentBlock();
        for (ApartmentBlock u : listapartment) {
            if (request.getParameter("AblockID").equals(u.getAblockID())) {
                a = u;
            }
            
        }
        boolean validation = true;
        if(validation){
            Employee em = new Employee(email, fullname, pass, a);
            emdao.create(em);
        List<Employee> list = emdao.read();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Employee/employeeView.jsp");
        rd.forward(request, response);
            
            }else{
                        request.getRequestDispatcher("/view/admin/Employee/employeeCreate.jsp").forward(request, response);

        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
}
