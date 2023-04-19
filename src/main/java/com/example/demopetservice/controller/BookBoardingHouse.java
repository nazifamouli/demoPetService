package com.example.demopetservice.controller;

import com.example.demopetservice.model.BooKBoarding;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "BookBoardingHouse", value = "/bookBoarding")
public class BookBoardingHouse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int onwnerID = Integer.parseInt(request.getParameter("ownerId"));
        String boardName = request.getParameter("boardingName");
        HttpSession session = request.getSession();
        int idCustomer = (int)session.getAttribute("idUser");

        BooKBoarding booking = new BooKBoarding();
        booking.setOwnerId(onwnerID);
        booking.setBoardName(boardName);
        booking.setCustomerId(idCustomer);
        try {
            booking.bookBoarding();
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/PetOwnerHome.jsp");
        dispatcher.forward(request, response);
    }

}
