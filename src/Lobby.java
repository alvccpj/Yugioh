import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private List<Usuario> jogadores;
    private int maxJogadoresLobby;
    private String modalidadeJogo;

    public Lobby(int maxJogadoresLobby) {
        this.jogadores = new ArrayList<>();
        this.maxJogadoresLobby = maxJogadoresLobby;
    }

    public void entrarNoLobby(Usuario jogador) {
        if (jogadores.size() < maxJogadoresLobby) {
            jogadores.add(jogador);
            System.out.println(jogador.getUsuario() + " entrou no lobby.");
            tentarEncontrarAdversario(jogador);
        } else {
            System.out.println("O lobby está cheio. " + jogador.getUsuario() + " não pôde entrar.");
        }
    }

    public void tentarEncontrarAdversario(Usuario jogador) {
        int nivelJogador = jogador.getNivel();
        String modalidadeJogo = "Jogo Normal"; 

        for (Usuario adversario : jogadores) {
            if (adversario != jogador && adversario.getNivel() == nivelJogador && modalidadeJogo.equals("Jogo Normal")) {
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
} }

