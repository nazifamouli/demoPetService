package com.example.demopetservice.controller;

import com.example.demopetservice.model.PetSitter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RequestPetSitter", value = "/requestPetSitter")
public class RequestPetSitter extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/RequestPetsitter.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String location = request.getParameter("location");
        String city = request.getParameter("city");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String workingHour = request.getParameter("workinghour");
        String details = request.getParameter("info");
        HttpSession session = request.getSession();
        int idRequester = (int)session.getAttribute("idUser");

        PetSitter petsitter = new PetSitter();
        petsitter.setRequesterId(idRequester);
        petsitter.setTitle(title);
        petsitter.setLocation(location);
        petsitter.setCity(city);
        petsitter.setSalary(salary);
        petsitter.setWorkingHour(workingHour);
        petsitter.setDetails(details);
        try {
            petsitter.requestPetsitter();
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/RequestPetsitter.jsp");
        dispatcher.forward(request, response);
    }
}
