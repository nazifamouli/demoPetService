package com.example.demopetservice.controller;

import com.example.demopetservice.model.Job;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "jobConfirm", value= "/jobconfirm")
public class JobConfim extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int employerId = (int)session.getAttribute("idUser");
        int jobId = Integer.parseInt(request.getParameter("jobId"));

        Job job = new Job();
        job.setJobId(jobId);
        try {
            job.confirmJob();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AppliedPetsitter.jsp");
        dispatcher.forward(request, response);
    }
}
