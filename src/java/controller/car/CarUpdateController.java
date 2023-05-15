/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.car;

import dao.carDAO;
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
import model.Users;

/**
 *
 * @author TADAR
 */
@WebServlet(name = "CarUpdateController", urlPatterns = {"/CarUpdateController"})
public class CarUpdateController extends HttpServlet {
   private final carDAO cardao = new carDAO();
    private final userDAO userdao = new userDAO();
    private java.util.List<Car> listcar = new ArrayList<>();
    private java.util.List<Users> listuser = new ArrayList<>();
    private List<Car> list = new ArrayList<>();
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String id = request.getParameter("id");
        Car car = cardao.details(id);
        request.setAttribute("car", car);
        listuser = userdao.read();
        request.setAttribute("listuser", listuser);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Car/carUpdate.jsp");
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
        String id = request.getParameter("id");
        String ten = request.getParameter("name");
        String plate = request.getParameter("plate");
        Users user = new Users();
        for (Users u : listuser) {
            if (request.getParameter("userID").equals(u.getUserID())) {
                user = u;
            }
            boolean validation = true;
        if(validation){
        Car cn = new Car(id, ten, plate, user);
        cardao.update(cn);
        List<Car> list = cardao.read();
        request.setAttribute("list", list);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/admin/Car/carview.jsp");
        rd.forward(request, response);
        }else{
             request.getRequestDispatcher("/view/admin/Car/carUpdate.jsp").forward(request, response);
             }

        }
    }
}
