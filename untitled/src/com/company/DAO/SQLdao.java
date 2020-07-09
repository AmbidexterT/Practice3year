package com.company.DAO;
//import com.company.Menu.ConnectionPool;

import java.sql.*;
import java.lang.String;
import java.util.Scanner;

public class SQLdao implements DAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/new?serverTimezone=Europe/Moscow&useSSL=false";


    public Connection createConnection(String user,String password) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB connection is successful");
        }
        catch(SQLException | ClassNotFoundException e) {
            System.out.println("DB connection not established");
            System.exit(0);
        }
        return connection;
    }

    @Override
    public void createTable(String Query, Connection connection) throws ClassNotFoundException, Exception {
        String[] subStr; String divider = " "; subStr = Query.split(divider);
        if ((subStr[0].equals("Create"))) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(Query);
            System.out.println("Table is created");
        } else {
            System.out.println("Error in syntax");
        }
    }

    @Override
    public void dropTable(String Query, Connection connection) throws ClassNotFoundException, Exception {
        String[] subStr; String divider = " "; subStr = Query.split(divider);
        if ((subStr[0].equals("Drop"))) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(Query);
            System.out.println("Table is deleted");
        } else {
            System.out.println("Error in syntax");
        }
    }

    @Override
    public void disconnect(Connection connection) throws Exception {
        System.out.println("Disconnected");
        connection.close();
    }

    public void insert(String Query, Connection connection) throws Exception{
        String[] subStr; String divider = " "; subStr = Query.split(divider);
        if ((subStr[0].equals("Insert"))) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(Query);
            System.out.println("Added new information in table");
        } else {
            System.out.println("Error in syntax");
        }
    }

    @Override
    public void update(String Query, Connection connection) throws Exception {
        String[] subStr; String divider = " "; subStr = Query.split(divider);
        if ((subStr[0].equals("Update"))) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(Query);
            System.out.println("Table updated");
        } else {
            System.out.println("Error in syntax");
        }
    }


    @Override
    public void select(String Query, Connection connection) throws Exception {
        String[] subStr; String divider = " "; subStr = Query.split(divider);
        if ((subStr[0].equals("Update"))) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(Query);
            System.out.println("Find in the table column matches");
        } else {
            System.out.println("Error in syntax");
        }
    }
}





