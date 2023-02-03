/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**

 @author bruno
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3307/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";




      public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName (DRIVER);
            return DriverManager.getConnection (URL, USER, PASS);
        } catch (SQLException ex) {
           throw new RuntimeException("Erro ao fechar a conex�o com o Banco de Dados", ex);
} 

}

    /**
     *
     * @param connection
     */
    public static void closeConnection(Connection connection) {
         try {
             if (connection != null) {
                 connection.close();
         }
         } catch (SQLException e){ 
                throw new RuntimeException(e); 
          }
         }
 

    public static void closeConnection(Connection connection, PreparedStatement statement){
         try {
             if (connection != null) {
                 connection.close();
             }
             if (statement != null) {
                 statement.close();
             }

         } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o Banco de Dados", ex);
         }

    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
         try {
             if (connection != null) {
                 connection.close();
             }
             if (statement != null) {
                 statement.close();
             }

             if (resultSet != null) {
                 resultSet.close();
             }

         } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o Banco de Dados", ex);
         }

    }

}
