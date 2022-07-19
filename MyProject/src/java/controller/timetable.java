package controller;

import dal.CouseDBContext;
import dal.StudentCouseDBContext;
import dal.WeeklyDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import model.Account;
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
        HttpSession aSession = request.getSession();
        Account acc = (Account) aSession.getAttribute("acc");
        if (acc == null) {
            response.getWriter().print("access denied");
            return;
        }

        ArrayList<String> campusList = new ArrayList<>();
        campusList.add("FU-HL");
        campusList.add("FU-Hồ Chí Minh");
        campusList.add("FU-Đà Nẵng");
        campusList.add("FU-Quy Nhơn");
        campusList.add("FU-Cần Thơ");
        request.setAttribute("campusList", campusList);
        WeeklyDBContext wDBC = new WeeklyDBContext();
        ArrayList<Weekly> weekList = wDBC.list();
        request.setAttribute("weekList", weekList);
        //input:campus(String),
        //      lecture(String)         
        //      noOfWeek(int)        Ex: 2
        //output:7 dayOfWeeks (of this week, now) Ex: 10/1/2022 to 16/1/2022 (for week 2)
        //       numberOfWeek(int) (of this week, now)
        //         lessons (arrayList)   all lesson of this week(now) for that input 
        //       statusList (ArrayList<String>) (dua vao lessons ben tren)
        //Date: now  
        String campus = request.getParameter("campus");
        String lecture = request.getParameter("lecture");
        //return output numberOfWeek(int) 
        int numberOfWeek = Integer.parseInt(request.getParameter("numberOfWeek"));
        request.setAttribute("numberOfWeek", numberOfWeek);
        //System.out.println(start.toString()+"------"+end.toString()+"------"+numberOfWeekNow+"------------"+(double)DAYS.between(end,start)/7);
        //return output 7 dayOfWeeks (of this week, now):
        request.setAttribute("dayOfWeeks", wDBC.getDaysOfWeek(numberOfWeek));
        //return output lessons
        CouseDBContext lDBC = new CouseDBContext();
        ArrayList<Couse> couses = lDBC.listAllCouseInThisWeekAndLecture(numberOfWeek, lecture);
        request.setAttribute("lessons", couses);
        //return output statusList
        ArrayList<String> statusList = new ArrayList<>();
        StudentCouseDBContext slDBC = new StudentCouseDBContext();
        for (Couse a : couses) {
            int status = slDBC.getStatus(a);
            if (status == 0) {
                continue;
            }
            if (status > 0) {
                statusList.add(a.getId() + "_" + slDBC.getStatus(a));
            }
        }
        request.setAttribute("statuses", statusList);
        request.getRequestDispatcher("view/weeklytimetable.jsp").forward(request, response);
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


}
