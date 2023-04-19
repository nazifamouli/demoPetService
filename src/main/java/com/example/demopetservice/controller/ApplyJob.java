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

@WebServlet(name = "ApplyJob", value = "/applyJob")
public class ApplyJob extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int petSitterId = (int)session.getAttribute("idUser");
        int jobId= Integer.parseInt(request.getParameter("idJob"));
        int employerId = Integer.parseInt(request.getParameter("employerId"));
        String jobAdd = request.getParameter("jobAddress");
        String jobSalary = request.getParameter("jobSalary");
        String jobHour = request.getParameter("jobHour");

        Job applied = new Job();

        applied.setJobId(jobId);
        applied.setPetSitterId(petSitterId);
        applied.setEmployerId(employerId);
        applied.setJobAdd(jobAdd);
        applied.setJobSalary(jobSalary);
        applied.setJobHour(jobHour);
        try {
            applied.applyJob();
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/PetSitterHome.jsp");
        dispatcher.forward(request, response);
    }
}
