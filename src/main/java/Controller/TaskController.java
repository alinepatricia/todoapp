/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**

 @author bruno
 */
public class TaskController {
    public void save (Task task) {
       String sql = "INSERT INTO tasks (idProject, name, description, completed, notes, deadline, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

       Connection connection = null;
       PreparedStatement statement = null;
    }

    public void update(Task task) {

    }  

    public void removeById(int taskId) throws SQLException{

        String sql = "DELETE FROM tasks WHERE id = ?";

         Connection conn = null;
         PreparedStatement statement =  null;

         try {
            conn = ConnectionFactory.getConnection ();
            statement = conn.prepareStatement ( sql );
            statement.setInt ( 1, taskId);
            statement.execute ();
        } catch (SQLException e ) {
            throw new SQLException ("Erro ao deletar tarefa");
        } finally {
            ConnectionFactory.closeConnection (conn);
        }
    }

    public List<Taks> getAll (int idProject){
        return null;
    } 
}
