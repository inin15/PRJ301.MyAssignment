/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CouseDBContext;
import dal.LessonDBContext;

import dal.WeeklyDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Couse;
import model.Weekly;

/**
 *
 * @author Admin
 */
public class timetable extends HttpServlet {

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
        //input: no
        //output: campusList
        //        weekList
        //to weeklyTimetable.jsp
        ArrayList<String> campusList = new ArrayList<>();
        campusList.add("FU-HL");
        campusList.add("FU-Hồ Chí Minh");
        campusList.add("FU-Đà Nẵng");
        request.setAttribute("campusList", campusList);
        WeeklyDBContext wDBC = new WeeklyDBContext();
        ArrayList<Weekly> weekList = wDBC.list();
        request.setAttribute("weekList", weekList);
        request.getRequestDispatcher("view/weeklyTimetable.jsp").forward(request, response);
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
        //input:campus(String),
        //      lecture(String)
        //      numberOfWeek(int)
        //output:8 ArrayList: slot 1 to slot 8. Each slot contain Lesson in 7 day: Mon to Sun
        //       weekList(arrayList)
//       Date: now 
        String campus = request.getParameter("campus");
        String lecture = request.getParameter("lecture");
        int numberOfWeek = Integer.parseInt(request.getParameter("numberOfWeek"));
//validate 

        //output
        String slot = "";
        for (int i = 1; i <= 8; i++) { //for each slot:
            slot = "slot" + i;
            ArrayList<Couse> couses = new ArrayList<>();
            CouseDBContext ldbc = new CouseDBContext();
            //List of Lesson in slot i
            couses = ldbc.list(i,numberOfWeek);
            if(couses==null || couses.size()==0){
                continue;
            }
            request.setAttribute(slot, couses);

        }
        ArrayList<String> campusList = new ArrayList<>();
        campusList.add("FU-HL");
        campusList.add("FU-Hồ Chí Minh");
        campusList.add("FU-Đà Nẵng");
        request.setAttribute("campusList", campusList);
        WeeklyDBContext wDBC = new WeeklyDBContext();
        ArrayList<Weekly> weekList = wDBC.list();
        request.setAttribute("weekList", weekList);
        request.getRequestDispatcher("view/weeklyTimetable.jsp").forward(request, response);
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