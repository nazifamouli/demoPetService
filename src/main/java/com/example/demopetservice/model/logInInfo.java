package com.example.demopetservice.model;

import java.sql.*;

public class logInInfo {
    private int idUser;
    public boolean validateUser(String email, String password, String usertype) throws ClassNotFoundException {
        String query = "select idUser from user where email = ? and password = ? and usertype = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
            PreparedStatement preparedStatement = conn.prepareStatement(query))
        {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, usertype);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                this.idUser = rs.getInt("idUser");
                return true;
            }
            else {
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public int getIdUser(){
        return idUser;
    }













}
