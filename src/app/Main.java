package app;

import sql.DAO.UsuarioDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        //Salvando dados do usuario com SQL
        Usuario u = new Usuario();
        u.setUsuario("Jheymesson");
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

