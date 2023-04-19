package com.example.demopetservice.model;

import java.sql.*;

public class User {
    private String name;
    private String age;
    private String email;
    private String contact;
    private String address;
    private String city;
    private String password;
    private String usertype;
    public static int userId;

    public User(){

    }
    public User(String name, String age, String email, String contact, String add, String city){
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = add;
        this.city = city;
    }
    public int registerUser() throws ClassNotFoundException {
        String INSERT_USERS_SQL =" INSERT INTO user(name,age,email,contact,address,city,password,usertype) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            System.out.println(getName());
            preparedStatement.setString(1, getName());
            preparedStatement.setString(2, getAge());
            preparedStatement.setString(3, getEmail());
            preparedStatement.setString(4, getContact());
            preparedStatement.setString(5, getAddress());
            preparedStatement.setString(6, getCity());
            preparedStatement.setString(7, getPassword());
            preparedStatement.setString(8, getUsertype());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    public User userProfile() throws ClassNotFoundException {
        String query = " SELECT name,age,email,contact,address,city FROM user WHERE idUser = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        User user = null;
        //String u_name = null, u_age = null, u_email = null, u_contact = null, u_add = null, u_city = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PetService", "root", "root1234");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String usname = rs.getString("name");
                String usage = rs.getString("age");
                String usemail = rs.getString("email");
                String uscontact = rs.getString("contact");
                String usadd = rs.getString("address");
                String uscity = rs.getString("city");
                user = new User(usname, usage, usemail, uscontact, usadd, uscity);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setContact(String contact){
        this.contact = contact;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setUsertype(String usertype){
        this.usertype= usertype;
    }

    public String getName(){
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getEmail(){
        return email;
    }
    public String getAddress(){
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getContact(){
        return contact;
    }
    public String getPassword(){
        return password;
    }
    public String getUsertype(){
        return usertype;
    }
}
