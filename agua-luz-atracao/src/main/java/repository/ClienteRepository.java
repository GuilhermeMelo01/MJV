package repository;

import model.Cliente;

import java.sql.*;
import java.time.LocalDateTime;

public class ClienteRepository {

    private Connection conexao;

    public ClienteRepository(){
        this.conexao = ConnectionFactory.conectar();
    }

    public void save(Cliente cliente){
        String sql = "INSERT INTO cliente (nome, cpf) VALUES (?, ?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setDate(3, Date.valueOf(LocalDateTime.now().toString()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void udpate(){

    }

    public void delete(){

    }

    public void findAll(){

    }

    public void findById(){

    }
}
