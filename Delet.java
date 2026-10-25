/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Admin
 */
public class Delet extends HttpServlet {

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
            out.println("<title>Servlet Delet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Delet at " + request.getContextPath() + "</h1>");
            
               try {
    // 1. Driver Load karo
                            Class.forName("com.mysql.jdbc.Driver");

                            // 2. Database Connection establish karo
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crud", "root", "");

                            // 3. Statement create karo
                            Statement st = con.createStatement();

                            // 4. Request mathi roll number melvo
                            String r = request.getParameter("txtRlno");

                            // 5. Delete query banavo (Note: SQL Injection mate PreparedStatement vadhare saaru pade)
                            String qry = "Delete from student where rollno=" + r;
                            int rows = st.executeUpdate(qry);

                            // 6. Output print karo
                            out.println(rows + "<b> Record(s) Deleted</b>");

                            // 7. Connection close karo
                            st.close();
                            con.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // 8. Redirect/Forward to ViewData servlet
                        RequestDispatcher rd = request.getRequestDispatcher("view");
                        rd.forward(request, response);

            
            out.println("<h1> hellow to dleeete </h1>");
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
