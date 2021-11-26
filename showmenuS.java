/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author asus
 */
public class showmenuS extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();
            out.println("<html><head><style>td{text-align:center;}body{background-image: url('bgAbout.jpg');}</style></head><body style ='background-color:#FFFAF0' >");
            try 
            {  
             Class.forName("com.mysql.jdbc.Driver");  
             String url = "jdbc:mysql://localhost:3306/hackathon";
            Connection con = DriverManager.getConnection(url, "root", "");  
             Statement st = con.createStatement();  
             ResultSet rs = st.executeQuery("select * from menu");  
             out.println("<div align='center'><table border=1 width=50% height=50%>");  
             out.println("<tr><th>orderidId</th><th>Name</th><th>Slot</th><tr>");  
             while (rs.next()) 
             {  
                 int o = rs.getInt("order_id");  
                 String nm = rs.getString("name");  
                 int s = rs.getInt("slot");   
                 out.println("<tr><td>" + o + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");
            }
            out.println("</table></div>");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
