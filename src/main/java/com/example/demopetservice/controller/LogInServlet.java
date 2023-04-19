package com.example.demopetservice.controller;
import com.example.demopetservice.model.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");

        logInInfo userlog = new logInInfo();
        boolean isValidUser = false;
        try {
            isValidUser = userlog.validateUser(email,password,usertype);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(isValidUser){
            int idUser = userlog.getIdUser();

            HttpSession session = request.getSession();
            session.setAttribute("idUser", idUser);
            User.userId = idUser;
            BooKBoarding.userId = idUser;
            Job.userId = idUser;
            BoardingHouse.userId = idUser;

            if(usertype.equals("1")){
                response.sendRedirect("PetOwnerHome.jsp");
            } else if (usertype.equals("2")) {
                response.sendRedirect("PetSitterHome.jsp");
            }
            else {
                response.sendRedirect("BoardingHouseOwner.jsp");
            }
        }else {
            request.setAttribute("message", "Invalid email or password. Please try again.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
