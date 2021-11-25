/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;

public class cmloginS extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        out.println("<html><body style ='background-color:#FFFAF0' >");
        String name = request.getParameter("name");
        String n1 = name;
        String val="";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/hackathon";
            Connection con = DriverManager.getConnection(url, "root", "");
            
            PreparedStatement ps=con.prepareStatement("select * from cm where name = ?");
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            rs.next();
            val = rs.getString(1);
            if(val.equals(n1)){
                out.println("<br><BR><br><BR><h1 align='center' style='color:blue'>Welcome! "+val+"</h1><br><br><hr>");
            }
            else
                out.println("USer does not exist!");
        } 
        catch (ClassNotFoundException ce) {

            out.println("class not found");
            out.println(ce.getStackTrace());

        }
        catch (SQLException se) {
            out.println("<h1 align='center'>USer does not exist!</h1>");

        }
        catch (Exception e) {

            out.println(e.getStackTrace());

        } 
        out.println("<h3 align='center'><a href='cmlogin.html' style='color:white;text-decoration: none; font-size:20px; background-color:red;'>Go back</a></h3>");
        out.println("</body></html>");
        out.close();
        
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}