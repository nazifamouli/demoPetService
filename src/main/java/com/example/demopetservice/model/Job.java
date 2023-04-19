package com.example.demopetservice.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Job {
    private int jobId;
    private int employerId;
    private int petSitterId;
    private String petSitterName;
    private String petSitterContact;
    private String jobAdd;
    private String jobSalary;
    private String jobHour;
    private String jobConfirm;
    public static int userId;
    public Job(){

    }
    public Job(int jobid, String name, String contact, String jobadd, String salary, String hour, String confirm){
        this.jobId = jobid;
        this.petSitterName = name;
        this.petSitterContact = contact;
        this.jobAdd = jobadd;
        this.jobSalary = salary;
        this.jobHour = hour;
        this.jobConfirm = confirm;
    }
    public void applyJob() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        int result = 0;
        String query = " SELECT name,contact FROM USER Where idUser = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,petSitterId);
            System.out.println(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                petSitterName = rs.getString("name");
                petSitterContact = rs.getString("contact");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String query2="INSERT INTO ApplyJob VALUES (?, ?, ?, ?, ?,?,?,?,?)";
        System.out.println(query2);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query2)) {
            preparedStatement.setInt(1, getJobId());
            preparedStatement.setInt(2,getEmployerId());
            preparedStatement.setInt(3,getPetSitterId());
            preparedStatement.setString(4, getPetSitterName());
            preparedStatement.setString(5, getPetSitterContact());
            preparedStatement.setString(6, getJobAdd());
            preparedStatement.setString(7, getJobSalary());
            preparedStatement.setString(8, getJobHour());
            preparedStatement.setString(9, "In Review");
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Job> getAppliedList() throws ClassNotFoundException {
        List<Job> appliedList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "SELECT jobId,petSitterName,petsitterContact,jobAddress,jobSalary,jobHour,jobConfirm FROM ApplyJob WHERE employerId = ?";
        System.out.println("UserId: "+ userId);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,userId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int jobId = rs.getInt("jobId");
                String petSitterName = rs.getString("petSitterName");
                String petsitterContact = rs.getString("petSitterContact");
                String jobAddress = rs.getString("jobAddress");
                String jobSalary = rs.getString("jobSalary");
                String jobHour = rs.getString("jobHour");
                String jobConfirm = rs.getString("jobConfirm");

                appliedList.add(new Job(jobId,petSitterName,petsitterContact,jobAddress,jobSalary,jobHour,jobConfirm));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appliedList;
    }
    public List<Job> viewAppliedList() throws ClassNotFoundException {
        List<Job> appliedList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "SELECT jobId,petSitterName,petsitterContact,jobAddress,jobSalary,jobHour,jobConfirm FROM ApplyJob WHERE petsitterId = ?";
        System.out.println("UserId: "+ userId);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,userId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int jobId = rs.getInt("jobId");
                String petSitterName = rs.getString("petSitterName");
                String petsitterContact = rs.getString("petSitterContact");
                String jobAddress = rs.getString("jobAddress");
                String jobSalary = rs.getString("jobSalary");
                String jobHour = rs.getString("jobHour");
                String jobConfirm = rs.getString("jobConfirm");

                appliedList.add(new Job(jobId,petSitterName,petsitterContact,jobAddress,jobSalary,jobHour,jobConfirm));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appliedList;
    }
    public void confirmJob() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "UPDATE ApplyJob SET jobConfirm = 'Confirm' WHERE jobId = ? and employerId = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,jobId);
            preparedStatement.setInt(2,userId);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
            System.out.println(rowsAffected + " rows updated.");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public int getJobId() {
        return jobId;
    }

    public int getEmployerId() {
        return employerId;
    }

    public int getPetSitterId() {
        return petSitterId;
    }

    public String getPetSitterName() {
        return petSitterName;
    }

    public String getPetSitterContact() {
        return petSitterContact;
    }

    public String getJobAdd() {
        return jobAdd;
    }

    public String getJobHour() {
        return jobHour;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public String getJobConfirm() {
        return jobConfirm;
    }

    public void setJobConfirm(String jobConfirm) {
        this.jobConfirm = jobConfirm;
    }

    public void setPetSitterId(int petSitterId) {
        this.petSitterId = petSitterId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public void setPetSitterName(String petSitterName) {
        this.petSitterName = petSitterName;
    }

    public void setPetSitterContact(String petSitterContact) {
        this.petSitterContact = petSitterContact;
    }

    public void setJobAdd(String jobAdd) {
        this.jobAdd = jobAdd;
    }

    public void setJobHour(String jobHour) {
        this.jobHour = jobHour;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }


}
