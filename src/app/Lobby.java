package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exceptions.TimeOutException;

public class Lobby {
    private List<Usuario> jogadores;
    private int maxJogadoresLobby;
    private String modalidadeJogo;
    private long tempoLimiteEspera; // Tempo limite em milissegundos
    private static final long TEMPO_LIMITE_PADRAO = 60000;

    public Lobby(int maxJogadoresLobby) {
        this.jogadores = new ArrayList<>();
        this.maxJogadoresLobby = maxJogadoresLobby;
        this.modalidadeJogo = "Jogo Normal";
    }

    public void entrarNoLobby(Usuario jogador) throws TimeOutException {
        if (jogadores.size() < maxJogadoresLobby) {
            jogadores.add(jogador);
            System.out.println(jogador.getUsuario() + " entrou no lobby.");
            tentarEncontrarAdversario(jogador);
        } else {
            System.out.println("O lobby está cheio. " + jogador.getUsuario() + " não pôde entrar.");
        }
    }

    public void tentarEncontrarAdversario(Usuario jogador) throws TimeOutException {
        long tempoInicial = System.currentTimeMillis();

        while (jogadores.size() < 4 && (System.currentTimeMillis() - tempoInicial) < tempoLimiteEspera) {
            // Aguarde até encontrar adversários ou até atingir o tempo limite
        }

        if (jogadores.size() >= 4) {
            List<Usuario> jogadoresDisponiveis = new ArrayList<>(jogadores);
            jogadoresDisponiveis.remove(jogador);

            // Resto da lógica para formar times e iniciar a arena
        } else {
            System.out.println("Tempo limite atingido. Nenhum adversário encontrado a tempo.");
            throw new TimeOutException();
        }
        if (jogadores.size() >= 4) {
            List<Usuario> jogadoresDisponiveis = new ArrayList<>(jogadores);
            jogadoresDisponiveis.remove(jogador);

            Random random = new Random();
            List<Usuario> time1 = new ArrayList<>();
            List<Usuario> time2 = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                Usuario jogadorSelecionado = jogadoresDisponiveis.get(random.nextInt(jogadoresDisponiveis.size()));
                if (i < 2) {
                    time1.add(jogadorSelecionado);
                } else {
                    time2.add(jogadorSelecionado);
                }
                jogadoresDisponiveis.remove(jogadorSelecionado);
            }

            System.out.println("Partida encontrada!");
            iniciarArena(time1, time2, modalidadeJogo);
        } else {
            System.out.println("Aguardando por mais jogadores...");
        }
    }

    public void iniciarArena(List<Usuario> time1, List<Usuario> time2, String modalidadeJogo) {
        // Implemente a lógica para iniciar a arena com as duas equipes
    }
}
