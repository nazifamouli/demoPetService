package com.example.demopetservice.controller;

import com.example.demopetservice.model.BoardingHouse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewBoardingHouse", value = "/viewBoardingHouse")
public class ViewBoardingHouse extends HttpServlet {
    private BoardingHouse house;

    @Override
    public void init() throws ServletException {
        house = new BoardingHouse();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BoardingHouse> houseList = null;
        try {
            houseList = house.getBoardingHouseList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("houseList", houseList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewBoardingList.jsp");
        dispatcher.forward(request, response);
    }

}
