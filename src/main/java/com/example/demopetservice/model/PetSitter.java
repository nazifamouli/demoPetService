package com.example.demopetservice.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetSitter {
    private int idJobOffer;
    private int requesterId;
    private String title;
    private String location;
    private String city;
    private int salary;
    private String workingHour;
    private String details;


    public PetSitter(int jobId,int employId, String jobTitle, String jobLocation, String jobCity,int jobSalary,String jobHour, String jobInfo){
        this.idJobOffer = jobId;
        this.requesterId = employId;
        this.title = jobTitle;
        this.location = jobLocation;
        this.city = jobCity;
        this.salary = jobSalary;
        this.workingHour = jobHour;
        this.details = jobInfo;
    }
    public PetSitter(){

    }
    public void requestPetsitter()throws ClassNotFoundException{
            String query = "INSERT INTO JobOffer(idRequester,title,location,city,salary,workingHour,extraInfo) VALUES (?, ?, ?, ?, ?, ?, ?)" ;
            int result = 0;
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, requesterId);
                preparedStatement.setString(2,title);
                preparedStatement.setString(3,location);
                preparedStatement.setString(4,city);
                preparedStatement.setInt(5,salary);
                preparedStatement.setString(6,workingHour);
                preparedStatement.setString(7,details);

                System.out.println(preparedStatement);
                result = preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }
    public static List<PetSitter> getJobList() throws ClassNotFoundException {
        String query = "SELECT * FROM JobOffer";
        List<PetSitter> jobList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int jobId = rs.getInt("idJobOffer");
                int employerId = rs.getInt("idRequester");
                String jobTitle = rs.getString("title");
                String jobLocation = rs.getString("location");
                String jobCity = rs.getString("city");
                int jobSalary = rs.getInt("salary");
                String jobHour = rs.getString("workingHour");
                String jobInfo = rs.getString("extraInfo");

                jobList.add(new PetSitter(jobId, employerId, jobTitle, jobLocation,jobCity, jobSalary, jobHour,jobInfo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobList;
    }

    public int getIdJobOffer() {
        return idJobOffer;
    }

    public int getRequesterId() {
        return requesterId;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getWorkingHour() {
        return workingHour;
    }

    public int getSalary() {
        return salary;
    }

    public String getDetails() {
        return details;
    }

    public void setIdJobOffer(int idJobOffer) {
        this.idJobOffer = idJobOffer;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setWorkingHour(String workingHour) {
        this.workingHour = workingHour;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
