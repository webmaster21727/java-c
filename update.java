/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Admin
 */
public class update extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet update at " + request.getContextPath() + "</h1>");
            
            try {
    // 1. Driver Load karo
                        Class.forName("com.mysql.jdbc.Driver");

                        // 2. Database Connection establish karo
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crud", "root", "");

                        // 3. Statement create karo
                        Statement st = con.createStatement();

                        // 4. Request mathi parameters melvo
                        String r = request.getParameter("txtRlno");
                        String s = request.getParameter("txtName");
                        String c = request.getParameter("txtCity");

                        // 5. Update Query banavo (Multiline string error fix kari che)
                        String qry = "Update student set name='" + s + "', city='" + c + "' where rollno=" + r;

                        // out.print(qry); // Debugging mate use kari sako

                        // 6. Query execute karo ane output print karo
                        int rows = st.executeUpdate(qry);
                        out.println(rows + "<b> Record(s) Updated</b><br>");

                        // 7. Connection close karo
                        st.close();
                        con.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // 8. ViewData servlet par request forward karo
                    RequestDispatcher rd = request.getRequestDispatcher("view");
                    rd.forward(request, response);
            
            
            out.println("</body>");
            out.println("</html>");
        }
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
