package app;

import sql.DAO.UsuarioDAO;
import app.Usuario;

public class Main {
    public static void main(String[] args) throws Exception { 
        Usuario u = new Usuario();

        u.setUsuario("ViniTri");
        u.setCpf("vinitrigueiro");
        u.setSenha("123456789v");
        u.setIdade(30);
        u.setSexo('M');
        u.setEmail("ViniTri@gmail.com");
        u.setNivel(20);
        u.setCardcoinsUsuario(600);

        new UsuarioDAO().cadastrarUsuario(u);

    }
}

