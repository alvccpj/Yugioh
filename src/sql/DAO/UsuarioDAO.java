package sql.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql.conexao.Conexao;
import Usuario; //importar classe de usuario

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario Usuario){

        String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql); 
            ps.setString(1, Usuario.getNome());
            ps.setString(2, Usuario.getCpf());
            ps.setString(3, Usuario.getSenha());
            ps.setString(4, Usuario.getIdade());
            ps.setString(5, Usuario.getSexo());
            ps.setString(6, Usuario.getEmail());
            ps.setString(7, Usuario.getNivel());
            ps.setString(8, Usuario.getCardcoinsUsuario());


            ps.execute();
            ps.close();

        } catch (SQLException e) {
            
            //todo auto-generated catch block
            e.printStackTrace();
        }
    }
}
