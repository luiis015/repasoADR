package DAO;

import DATABASE.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public  boolean usuarioEstaRegistrado(String correo, String pass) {
    connection = DBConnection.getConnection();
    String query = "SELECT * FROM usuarios WHERE correoUsuario = ? AND passUsuario = ?";
    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, correo);
        preparedStatement.setString(2, pass);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    } catch (Exception e) {
        System.out.println("Error al conectar a la base de datos" + e.getMessage());
    }
    return false;
}
































}
