package app;

import sql.DAO.UsuarioDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        //Salvando dados do usuario com SQL
        Usuario u = new Usuario();
        u.setUsuario("UsuarioExemplo");
        u.setCpf("00011122233");
        u.setSenha("senha");
        u.setIdade(20);
        u.setSexo('M');
        u.setEmail("exemploemail@gmail.com");


        new UsuarioDAO().cadastrarUsuario(u);



    }
}

