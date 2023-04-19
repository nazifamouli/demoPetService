package com.example.demopetservice.controller;

import com.example.demopetservice.model.BoardingHouse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddBoardingHouse", value = "/AddBoardingHouse")
public class AddBoardingHouse extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/BoardingHouse.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String boardingName = request.getParameter("boardingName");
        String location = request.getParameter("location");
        int spaceAvailable = Integer.parseInt(request.getParameter("spaceAvailable"));
        String facility = request.getParameter("facility");
        int pay = Integer.parseInt(request.getParameter("pay"));
        String extraInfo = request.getParameter("info");
        HttpSession session = request.getSession();
        int ownerId = (int)session.getAttribute("idUser");

        BoardingHouse house = new BoardingHouse();
        house.setOwnerId(ownerId);
        house.setBoardingName(boardingName);
        house.setLocation(location);
        house.setSpaceAvailable(spaceAvailable);
        house.setFacility(facility);
        house.setPay(pay);
        house.setExtraInfo(extraInfo);
        try {
            house.addBoardingHouse();
        }catch (Exception e){
            e.printStackTrace();
            String errorMessage = "Error occurred. Please try again.";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/BoardingHouse.jsp");
            dispatcher.forward(request, response);
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/BoardingHouse.jsp");
        dispatcher.forward(request, response);
    }
}
