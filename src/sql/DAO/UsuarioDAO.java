package sql.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql.conexao.Conexao;
import app.Usuario;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario Usuario){

        String sql = "INSERT INTO USUARIO (NOME, CPF, SENHA, IDADE, SEXO, EMAIL, NIVEL, CARDCOINS ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql); 
            ps.setString(1, Usuario.getUsuario());
            ps.setString(2, Usuario.getCpf());
            ps.setString(3, Usuario.getSenha());
            ps.setInt(4, Usuario.getIdade());
            ps.setString(5, String.valueOf(Usuario.getSexo()));
            ps.setString(6, Usuario.getEmail());
            ps.setInt(7, Usuario.getNivel());
            ps.setDouble(8, Usuario.getCardcoinsUsuario());


            ps.execute();
            ps.close();

        } catch (SQLException e) {
            
            //todo auto-generated catch block
            e.printStackTrace();
        }
    }
}
