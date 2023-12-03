package app;

import sql.DAO.UsuarioDAO;

public class Main {
    public static void main(String[] args) throws Exception {

        //Salvando dados dos jogadores com SQL
        Usuario u = new Usuario();

        u.setUsuario("UsuarioExemplo");
        u.setCpf("00011122233");
        u.setSenha("senha");
        u.setIdade(20);
        u.setSexo('M');
        u.setEmail("exemploemail@gmail.com");

        new UsuarioDAO().cadastrarUsuario(u);

        Usuario jogador1 = new Usuario("Álvaro Jordão", "123456789", "senha123", 20, 'M', "alvaro@unicap.com", 1, new Inventario(), 0.0, new Deck[5], 0, 0, new Carta[10], 20);
        Usuario jogador2 = new Usuario("Vinícius Trigueiro", "173456789", "senha1234", 21, 'M', "viniciustri@unicap.com", 1, new Inventario(), 0.0, new Deck[5], 0, 0, new Carta[10], 20);
        Usuario jogador3 = new Usuario("Vinícius Rocha", "90867543565", "senha1235", 24, 'M', "rocha@unicap.com", 1, new Inventario(), 0.0, new Deck[5], 0, 0, new Carta[10], 20);
        Usuario jogador4 = new Usuario("João Pedro", "129996789", "senha12376", 25, 'M', "joaopedro@unicap.com", 1, new Inventario(), 0.0, new Deck[5], 0, 0, new Carta[10], 20);

        Inventario inventarioJogador1 = new Inventario(new Carta[200], 1, 0);
        Inventario inventarioJogador2 = new Inventario(new Carta[200], 1, 0);
        Inventario inventarioJogador3 = new Inventario(new Carta[200], 1, 0);
        Inventario inventarioJogador4 = new Inventario(new Carta[200], 1, 0);

        Carta cartaJogador1 = new Carta();
        Carta cartaJogador2 = new Carta();
        Carta cartaJogador3 = new Carta();
        Carta cartaJogador4 = new Carta();

        Deck deckJogador1 = new Deck();
        Deck deckJogador2 = new Deck();
        Deck deckJogador3 = new Deck();
        Deck deckJogador4 = new Deck();

        Loja lojaJogador1 = new Loja();
        Loja lojaJogador2 = new Loja();
        Loja lojaJogador3 = new Loja();
        Loja lojaJogador4 = new Loja();

        Lobby lobbyJogador1 = new Lobby();
        Lobby lobbyJogador2 = new Lobby();
        Lobby lobbyJogador3 = new Lobby();
        Lobby lobbyJogador4 = new Lobby();

        Arena arenaJogador1 = new Arena();
        Arena arenaJogador2 = new Arena();
        Arena arenaJogador3 = new Arena();
        Arena arenaJogador4 = new Arena();
    }
}

