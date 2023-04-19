package com.example.demopetservice.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardingHouse {
    private int ownerId;
    private String boardingName;
    private String location;
    private int spaceAvailable;
    private String facility;
    private int pay;
    private String info;
    public static int userId;

    public BoardingHouse(int boardOwner, String boardName, String boardLocation, int boardSpace, String boardFacility, int boardPay, String boardInfo) {
        this.ownerId = boardOwner;
        this.boardingName = boardName;
        this.location = boardLocation;
        this.spaceAvailable = boardSpace;
        this.facility = boardFacility;
        this.pay = boardPay;
        this.info = boardInfo;
    }
    public BoardingHouse(){

    }
    public BoardingHouse(String boardingName,String location,int space,String facility, int pay){
        this.boardingName = boardingName;
        this.location = location;
        this.spaceAvailable = space;
        this.facility = facility;
        this.pay = pay;
    }
    public void addBoardingHouse() throws ClassNotFoundException{
        String query = "INSERT INTO BoardingHouse VALUES (?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setInt(1,ownerId);
             preparedStatement.setString(2,boardingName);
             preparedStatement.setString(3,location);
             preparedStatement.setInt(4,spaceAvailable);
             preparedStatement.setString(5,facility);
             preparedStatement.setInt(6,pay);
             preparedStatement.setString(7,info);

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static List<BoardingHouse> getBoardingHouseList() throws ClassNotFoundException {
        String query = "SELECT * FROM BoardingHouse";
        List<BoardingHouse> houseList = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");

             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int boardOwner = rs.getInt("ownerId");
                String boardName = rs.getString("boardingName");
                String boardLocation = rs.getString("location");
                int boardSpace = rs.getInt("spaceAvailable");
                String boardFacility = rs.getString("facility");
                int boardPay = rs.getInt("pay");
                String boardInfo = rs.getString("extraInfo");

                houseList.add(new BoardingHouse(boardOwner,boardName,boardLocation,boardSpace,boardFacility,boardPay,boardInfo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return houseList;
    }
    public BoardingHouse getBoardingprofile() throws ClassNotFoundException{
        BoardingHouse houseProfile = new BoardingHouse();
        String query = " SELECT boardingName,location,spaceAvailable,facility,pay FROM BoardingHouse WHERE ownerId = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String boardname = rs.getString("boardingName");
                String location = rs.getString("location");
                int space = rs.getInt("spaceAvailable");
                String facility = rs.getString("facility");
                int pay = rs.getInt("pay");
                houseProfile = new BoardingHouse(boardname,location,space,facility,pay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return houseProfile;
    }
    public void updateBoarding() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "UPDATE BoardingHouse SET spaceAvailable = ?,facility = ?,pay = ? WHERE ownerId = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,spaceAvailable);
            preparedStatement.setString(2,facility);
            preparedStatement.setInt(3,pay);
            preparedStatement.setInt(4, userId);
            System.out.println(preparedStatement);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
            System.out.println(rowsAffected + " rows updated.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void setOwnerId(int ownerId){
        this.ownerId = ownerId;
    }

    public void setBoardingName(String boardingName) {
        this.boardingName = boardingName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSpaceAvailable(int spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public void setExtraInfo(String info) {
        this.info = info;
    }

    public int getOwnerId() {
        return ownerId;
    }
    public String getBoardingName() {
        return boardingName;
    }

    public String getLocation() {
        return location;
    }

    public int getSpaceAvailable() {
        return spaceAvailable;
    }

    public String getFacility() {
        return facility;
    }
    public int getPay() {
        return pay;
    }

    public String getExtraInfo() {
        return info;
    }
}
