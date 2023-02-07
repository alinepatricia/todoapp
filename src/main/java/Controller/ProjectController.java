/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**

 @author aline
 */
public class ProjectController {

    private int Id;
    
public void save (Project project) throws ClassNotFoundException {
       String sql = "INSERT INTO Projects (name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?)";

       Connection connection = null;
       PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement ( sql );

            statement.setString ( 1, project.getDescription ());
            statement.setString ( 2, project.getName ());
            statement.setDate ( 3, new Date (project.getCreatedAt ().getTime ()));
            statement.setDate ( 4, new Date (project.getUpdatedAt ().getTime ()));
            statement.execute ();
            
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao salvar tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection ( connection, statement );
        }
    }

    public void update(Project project) {
        String sql = "UPDATE tasks SET name = ?, description = ?, createdAt = ?, updatedAt = ?, WHERE id = ?";

       Connection connection = null;
       PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection ();
            statement = connection.prepareStatement ( sql );

            statement.setString ( 2, project.getName ());
            statement.setString ( 3, project.getDescription ());
            statement.setDate ( 7, new Date (project.getCreatedAt ().getTime ()));
            statement.setDate ( 8, new Date (project.getUpdatedAt ().getTime ()));
            statement.setInt(5, project.getId ());
            statement.execute ();
        } catch ( Exception ex ) {
            throw new RuntimeException ("Erro ao atualizar tarefa" + ex.getMessage(), ex);
        } 
    }  
public List<Project> getAll () throws ClassNotFoundException{
        
        String sql = "SELECT * FROM projects";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> Projects = new ArrayList<> ();

        try {
            connection = ConnectionFactory.getConnection ();
            statement = connection.prepareStatement ( sql );

            resultSet = statement.executeQuery ();

            while ( resultSet.next()) {
                
                Project project = new Project ();

                project.setId(resultSet.getInt("id"));
                project.setName ( resultSet.getString ( "name"));
                project.setDescription ( resultSet.getString ( "description"));
                project.setCreatedAt ( resultSet.getDate ( "createdAt"));
                project.setUpdatedAt (resultSet.getDate ("updatedAt"));

                project.add ( project );
            }
        } catch (SQLException ex ) {
                throw new RuntimeException ("Erro ao buscar projetos", ex);
        } finally {
                ConnectionFactory.closeConnection ( connection, statement, resultSet );
        }

        return Projects;
    } 

    /**
     *
     * @param idProject
     * @throws java.lang.ClassNotFoundException
     */
    public void removeById(int idProject) throws ClassNotFoundException{

        String sql = "DELETE FROM projects WHERE id = ?";

         Connection connection = null;
         PreparedStatement statement =  null;

         try {
            connection = ConnectionFactory.getConnection ();
            statement = connection.prepareStatement ( sql );
            statement.setInt ( 1, Id);
            statement.execute ();
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao deletar tarefa",ex);
        } finally {
            ConnectionFactory.closeConnection (connection, statement);
        }
    }
}
