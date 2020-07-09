package com.company.Menu;

import com.company.DAO.SQLdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    //public SQLdao daaaa = new SQLdao();
    public Menu() throws Exception {
    }

    public void Hyper() throws Exception {
        Scanner in = new Scanner(System.in);
        SQLdao dao = new SQLdao();

            //SQLdao dao = new SQLdao();
            SQLdao daaaa = new SQLdao();

            System.out.println("Connection:");
            System.out.println("Username");
            String user = in.nextLine();
            System.out.println("Password");
            String password = in.nextLine();
           Connection connection = daaaa.createConnection(user, password);
           System.out.println("Options: Create, Drop, Insert, Update, Select, EXIT");
           while (true) {

            String data = in.nextLine();
            String[] subStr;
            String divider = " ";
            subStr = data.split(divider);
            //System.out.println("Create, Drop, Insert, Update, Select, EXIT");
               switch (subStr[0]) {
                case "Create" -> {
                    while (data.isEmpty()) {
                        data = in.nextLine();
                    }
                    dao.createTable(data, connection);
                }
                case "Drop" -> {
                    while (data.isEmpty()) {
                        data = in.nextLine();
                    }
                    dao.dropTable(data, connection);
                }
                case "Insert" -> {
                    while (data.isEmpty()) {
                        data = in.nextLine();
                    }
                    dao.insert(data, connection);
                }
                case "Update" -> {
                    while (data.isEmpty()) {
                        data = in.nextLine();
                    }
                    dao.update(data, connection);
                }
                case "Select" -> {
                    while (data.isEmpty()) {
                        data = in.nextLine();
                    }
                    dao.select(data, connection);
                }
                case "EXIT" -> {
                    while (data.isEmpty()) {
                        data = in.nextLine();
                    }
                    dao.disconnect(connection);
                    return;
                }
            }
        }
    }
}