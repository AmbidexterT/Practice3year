package com.company.DAO;
import com.company.DAO.SQLdao;
import java.sql.Connection;
import java.sql.SQLException;

public interface DAO {
    Connection createConnection(String user,String password) throws SQLException;
    void createTable(String Query, Connection connection) throws Exception;
    void dropTable(String Query, Connection connection) throws Exception;
    void disconnect(Connection connection) throws Exception;
    void insert(String Query, Connection connection) throws Exception;
    void update(String Query, Connection connection) throws Exception;
    void select(String Query, Connection connection) throws Exception;
}
