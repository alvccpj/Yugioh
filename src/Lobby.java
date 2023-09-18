public class Lobby {
    private Usuario[] jogadores;
    private int maxJogadoresLobby;
    private String modalidadeJogo;
    private int numJogadores;

    public Lobby(int maxJogadoresLobby) {
        this.jogadores = new Usuario[maxJogadoresLobby];
        this.maxJogadoresLobby = maxJogadoresLobby;
        this.numJogadores = 0;
    }

    public void entrarNoLobby(Usuario jogador) {
        if (numJogadores < maxJogadoresLobby) {
            jogadores[numJogadores] = jogador;
            numJogadores++;
            System.out.println(jogador.getUsuario() + " entrou no lobby.");
            tentarEncontrarAdversario(jogador);
        } else {
            System.out.println("O lobby está cheio. " + jogador.getUsuario() + " não pôde entrar.");
        }
    }

    public void tentarEncontrarAdversario(Usuario jogador) {
        int nivelJogador = jogador.getNivel();
        modalidadeJogo = "Jogo Normal"; 

        for (Usuario adversario : jogadores) {
            if (adversario != null && adversario != jogador && adversario.getNivel() == nivelJogador && modalidadeJogo.equals("Jogo Normal")) {
                System.out.println("Partida encontrada!");
                iniciarArena(jogador, adversario, modalidadeJogo);
                return;
            }
        }

        System.out.println("Aguardando por um adversário...");
    }

    public void iniciarArena(Usuario jogador1, Usuario jogador2, String modalidadeJogo) {
        Arena arena = new Arena(jogador1, jogador2, modalidadeJogo);
        arena.iniciarJogo();
    }
}
