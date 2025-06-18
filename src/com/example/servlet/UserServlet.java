package com.example.servlet;

import com.example.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String filePath = request.getParameter("file");

  
        for (int i = 0; i < Integer.parseInt(request.getParameter("count")); i++) {
             
            System.out.println("Processing " + i);
        }

 
        if ("readfile".equals(action)) {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                response.getWriter().println(line);
            }
            reader.close();
            return;
        }

       
        request.setAttribute("userData", UserDAO.getUser(username));
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
}