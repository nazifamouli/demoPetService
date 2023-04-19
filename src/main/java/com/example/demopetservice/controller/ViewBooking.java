package com.example.demopetservice.controller;

import com.example.demopetservice.model.BoardingHouse;
import com.example.demopetservice.model.BooKBoarding;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewBooking", value = "/ViewBooking")
public class ViewBooking extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*HttpSession session = request.getSession();
        int idRequester = (int)session.getAttribute("idUser");
        BooKBoarding.userId = idRequester;*/
        //System.out.println("Requester id"+idRequester);
        /*BooKBoarding book = new BooKBoarding();
        List<BooKBoarding> bookingList = null;
        try {
            bookingList = book.getBookingList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(bookingList);
        request.setAttribute("bookingList", bookingList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewBooking.jsp");
        dispatcher.forward(request, response);*/
    }
}
