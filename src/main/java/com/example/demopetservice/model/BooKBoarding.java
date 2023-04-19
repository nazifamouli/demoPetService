package com.example.demopetservice.model;

import jakarta.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooKBoarding {
    private String boardName;
    private int customerId;

    private String customerName;
    private String customerAddress;
    private String customerContact;
    private int ownerId;
    public static int userId;

    public BooKBoarding(){

    }
    public BooKBoarding(String boardingName, int customerID, String name, String address, String contact){
        boardName = boardingName;
        customerId = customerID;
        customerName = name;
        customerAddress = address;
        customerContact = contact;

    }
    public void bookBoarding() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        int result = 0;
        String query = " SELECT name,contact,address FROM USER Where idUser = ?";
        System.out.println(query);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,getCustomerId());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                customerName = rs.getString("name");
                customerContact = rs.getString("contact");
                customerAddress = rs.getString("address");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String query2=" INSERT INTO BookBoarding VALUES (?,?, ?, ?, ?, ?)";
        System.out.println(query2);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query2)) {
            preparedStatement.setInt(1,getOwnerId());
            preparedStatement.setString(2, getBoardName());
            preparedStatement.setInt(3, getCustomerId());
            preparedStatement.setString(4,customerName);
            preparedStatement.setString(5,customerAddress);
            preparedStatement.setString(6,customerContact);
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        String query3 = "UPDATE BoardingHouse SET spaceAvailable = spaceAvailable - 1 WHERE boardingName = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query3)) {
            preparedStatement.setString(1, getBoardName());
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowAffected);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<BooKBoarding> getBookingList() throws ClassNotFoundException {
        List<BooKBoarding> bookList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "SELECT * FROM BookBoarding WHERE ownerId = ?";
        System.out.println("UserId: "+ userId);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,userId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ownId = rs.getInt("ownerId");
                String boardName = rs.getString("BoardingName");
                int custId = rs.getInt("CustomerId");
                String custName = rs.getString("Name");
                String custAddress = rs.getString("Address");
                String custContact = rs.getString("Contact");

                bookList.add(new BooKBoarding(boardName, custId, custName, custAddress, custContact));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
    public List<BooKBoarding> getPetownerBooking() throws ClassNotFoundException {
        List<BooKBoarding> petBoardList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "SELECT * FROM BookBoarding WHERE customerId = ?";
        System.out.println("UserId: "+ userId);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,userId);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ownId = rs.getInt("ownerId");
                String boardName = rs.getString("BoardingName");
                int custId = rs.getInt("CustomerId");
                String custName = rs.getString("Name");
                String custAddress = rs.getString("Address");
                String custContact = rs.getString("Contact");

                petBoardList.add(new BooKBoarding(boardName, custId, custName, custAddress, custContact));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petBoardList;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerContact() {
        return customerContact;
    }
}
