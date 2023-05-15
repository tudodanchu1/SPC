/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Employee;

import controller.Employee.*;
import dao.ApartmentBlockDAO;
import dao.employeeDAO;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ApartmentBlock;
import model.Employee;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "EmployeeUpdateController", urlPatterns = {"/EmployeeUpdateController"})
public class EmployeeUpdateController extends HttpServlet {
    private final employeeDAO emdao = new employeeDAO();
    private final ApartmentBlockDAO adao = new ApartmentBlockDAO();
    private java.util.List<Employee> listemployee = new ArrayList<>();
    private java.util.List<ApartmentBlock> listapartmentblock = new ArrayList<>();
    private List<Employee> list = new ArrayList<>();
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee Employee = emdao.details(id);
        request.setAttribute("employee", Employee);
        listapartmentblock = adao.read();
        request.setAttribute("listapartment", listapartmentblock);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Employee/employeeUpdate.jsp");
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
        String email= request.getParameter("email");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        ApartmentBlock apartmentblock = new ApartmentBlock();
        for (ApartmentBlock a : listapartmentblock) {
            if (request.getParameter("AblockID").equals(a.getAblockID())) {
                apartmentblock = a;
            }
            boolean validation = true;
        if(validation){
        Employee cn = new Employee(email, fullname, password, apartmentblock);
        emdao.update(cn);
        List<Employee> list = emdao.read();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Employee/employeeView.jsp");
        rd.forward(request, response);
        }else{
             request.getRequestDispatcher("/view/admin/Employee/EmployeeUpdate.jsp").forward(request, response);
             }

        }
    }
}
