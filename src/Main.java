public class Main {
    public static void main(String[] args) {
        // Criação de objetos de usuário
        Usuario usuario1 = new Usuario("Usuario1", "123456789", "senha123", 25, 'M', "usuario1@example.com", 1, new Inventario(), 100);
        Usuario usuario2 = new Usuario("Usuario2", "987654321", "senha456", 30, 'F', "usuario2@example.com", 2, new Inventario(), 50);

        // Criação de objetos de cartas
        Carta carta1 = new Carta("Carta 1", "imagem1", "tipo1", "COMUM", 5, 3, 2, "habilidade1", 0, 0);
        Carta carta2 = new Carta("Carta 2", "imagem2", "tipo2", "RARA", 8, 4, 3, "habilidade2", 0, 0);

        // Criação de decks
        Deck deck1 = new Deck("Deck1", new Carta[] { carta1, carta2 });
        Deck deck2 = new Deck("Deck2", new Carta[] { carta2, carta1 });

        // Adicionar decks aos usuários
        usuario1.adicionarDeck(deck1);
        usuario2.adicionarDeck(deck2);

        // Criação de uma loja
        Loja loja = new Loja("1234-5678-9012-3456", "123");

        // Compra de booster pack na loja
        loja.compraDeBooster(usuario1, usuario1.getInventario());

        // Entrar no lobby
        Lobby lobby = new Lobby(2);
        lobby.entrarNoLobby(usuario1);
        lobby.entrarNoLobby(usuario2);

        // As demais operações no lobby e na arena podem ser testadas de acordo com a lógica do seu jogo.

        // Exemplo de finalização de partida na arena
        Arena arena = new Arena(usuario1, usuario2, "Jogo Normal");
        arena.iniciarJogo();
    }
}
