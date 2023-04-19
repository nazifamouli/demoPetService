package com.example.demopetservice.controller;

import com.example.demopetservice.model.BoardingHouse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "updateBoard", value = "/updateBoarding")
public class updateBoardingProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String boardName = request.getParameter("boardName");
        int spaceAvailable = Integer.parseInt(request.getParameter("spaceAvailable"));
        String facility = request.getParameter("facility");
        int pay =Integer.parseInt(request.getParameter("pay"));

        BoardingHouse house = new BoardingHouse();
        house.setBoardingName(boardName);
        house.setSpaceAvailable(spaceAvailable);
        house.setFacility(facility);
        house.setPay(pay);

        try {
            house.updateBoarding();
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/BoardingHouseManage.jsp");
        dispatcher.forward(request, response);
    }
}
