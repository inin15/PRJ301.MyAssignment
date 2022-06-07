/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package view;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.MyRect;

/**
 *
 * @author Ngo Tung Son
 */
public class RectView extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ArrayList<MyRect> rects  = (ArrayList<MyRect>)request.getAttribute("rects");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<body>\n"
                + "<canvas id=\"myCanvas\" width=\"500\" height=\"500\" style=\"border:1px solid #d3d3d3;\">\n"
                + "Your browser does not support the HTML5 canvas tag.</canvas>\n"
                + "<script>\n"
                + "var c = document.getElementById(\"myCanvas\");\n"
                + "var ctx = c.getContext(\"2d\");");
//        for (MyRect rect : rects) {
//            response.getWriter().println("ctx.beginPath();\n"
//                    + "ctx.rect("+rect.getX()+", "+rect.getY()
//                    +", "+rect.getW()+", "+rect.getH()+");\n"
//                    + "ctx.fillStyle = \"rgb("+rect.getRed()+","+rect.getGreen()+","+rect.getBlue()+")\";\n"
//                    + "ctx.fill();");
//        }
        response.getWriter().println("</script> \n"
                + "</body>\n"
                + "</html>");
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
