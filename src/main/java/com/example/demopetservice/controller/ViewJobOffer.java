package com.example.demopetservice.controller;

import com.example.demopetservice.model.BoardingHouse;
import com.example.demopetservice.model.PetSitter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewJobOffer", value = "/ViewJobOffer")
public class ViewJobOffer extends HttpServlet {
    private PetSitter job;

    public void init() throws ServletException {
        job = new PetSitter();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<PetSitter> jobList = null;
        try {
            jobList = job.getJobList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("jobList", jobList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewJobOffer.jsp");
        dispatcher.forward(request, response);
    }
}
