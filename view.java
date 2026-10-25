    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template


    import java.io.IOException;
    import java.io.PrintWriter;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.Statement;
    import java.sql.ResultSet;
    import java.servlet.ServletException;
    import java.servlet.annotation.WebServlet;
    import java.servlet.http.HttpServlet;
    import java.servlet.http.HttpServletRequest;
    import java.servlet.http.HttpServletResponse;
    */

    import java.io.IOException;
    import java.io.PrintWriter;
    import java.sql.*;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet; // Added import
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.sql.ResultSet;
    /**
     *
     * @author Admin
     */
    public class view extends HttpServlet {

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
                out.println("<title>Servlet view</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet view at " + request.getContextPath() + "</h1>");

                    try {
                    // 1. Database Driver Load Karo (Updated for modern MySQL)
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // 2. Connection Establish Karo
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
                    Statement st = con.createStatement();

                    // 3. Select Query Run Karo
                    String qry = "SELECT * FROM student";
                    ResultSet rs = st.executeQuery(qry);

                    // 4. HTML Table Banavo
                    out.println("<table border='1' cellpadding='8'>");
                    out.println("<caption><h3>Student's List</h3></caption>");
                    out.println("<tr>");
                    out.println("<th>Rlno</th><th>Name</th><th>City</th>");
                    out.println("</tr>");

                    // 5. Data Loop thi Table Row Ma Print Karo
                    while (rs.next()) {
                        
                        int r = rs.getInt("rollno");
                        String s = rs.getString("name");
                        String c = rs.getString("city");

                        out.println("<tr>");
                        out.println("<td>" + r + "</td><td>" + s + "</td><td>" + c + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");

                    // 6. Resources Close Karo
                    rs.close();
                    st.close();
                    con.close();

                } catch (Exception e) {
                    out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
                    e.printStackTrace(out);
                }

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
