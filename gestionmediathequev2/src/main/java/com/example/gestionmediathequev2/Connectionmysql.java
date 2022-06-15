package com.example.gestionmediathequev2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionmysql {
    public static Connection cn=null;
    public static Connection connectionDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionmediatheque","root","");
            System.out.println("connexion reussite");
            return cn;
        } catch (ClassNotFoundException e) {
            System.out.println("Connection echouee");
            e.printStackTrace();
            return null;


        } catch (SQLException e) {
            System.out.println("Connection echouee");
            e.printStackTrace();
            return null;

        }

    }
}
