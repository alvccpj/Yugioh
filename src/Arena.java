import java.util.ArrayList;
import java.util.Random;

public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Carta[][] campoJogador1 = new Carta[2][5];
    private Carta[][] campoJogador2 = new Carta[2][5];
    private int vidaJogador1 = 20;
    private int vidaJogador2 = 20;
    private boolean jogoEncerrado = false;
    private Carta[] maoJogador1 = new Carta[10];
    private Carta[] maoJogador2 = new Carta[10];
    private int manaMaximaJogador1 = 0;
    private int manaMaximaJogador2 = 0;
    private ArrayList<Carta> cemiterioJogador1 = new ArrayList<>();
    private ArrayList<Carta> cemiterioJogador2 = new ArrayList<>();

    public Arena(Usuario jogador1, Usuario jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        jogador1.setMao(new Carta[10]);
        jogador2.setMao(new Carta[10]);
    }

    public void iniciarJogo() {
        System.out.println("Iniciando partida entre " + jogador1.getUsuario() + " e " + jogador2.getUsuario());
        while (!jogoEncerrado) {
            regraJogo();
        }
    }

    private void regraJogo() {
        fazerTurno(jogador1);
        fazerTurno(jogador2);

        if (vidaJogador1 <= 0 || vidaJogador2 <= 0) {
            jogoEncerrado = true;
            finalizarJogo();
        }
    }

    private void fazerTurno(Usuario jogador) {
        saque(jogador);

        posicionar(jogador);

        ataque(jogador, jogador == jogador1 ? jogador2 : jogador1);

        if (jogador == jogador1) {
            jogador = jogador2;
        } else {
            jogador = jogador1;
        }
    }

    private void finalizarJogo() {
        if (vidaJogador1 <= 0) {
            System.out.println(jogador2.getUsuario() + " venceu!");
        } else if (vidaJogador2 <= 0) {
            System.out.println(jogador1.getUsuario() + " venceu!");
        } else {
            System.out.println("O jogo terminou em empate!");
        }
    }

    private void saque(Usuario jogador) {
        Random random = new Random();
        Deck[] decks = jogador.getDecks();
        ArrayList<Carta> cartasAleatorias = new ArrayList<>();

        int cartasRestantes = 7;

        for (int i = 0; i < decks.length && cartasRestantes > 0; i++) {
            int indiceDeck = random.nextInt(decks.length);
            Deck deck = decks[indiceDeck];

            if (deck != null) {
                Carta carta = deck.obterCartaAleatoria();

                if (carta != null) {
                    cartasAleatorias.add(carta);
                    Inventario inventario;
                    deck.removerCartaDoDeck(carta, inventario);
                    cartasRestantes--;
                }
            }
        }

        jogador.setDecks(decks);
        jogador.setMao(cartasAleatorias.toArray(new Carta[0]));
    }

    private void posicionar(Usuario jogador) {
        if (jogador == jogador1) {
            if (jogador.getMao().length > 0) {
                Carta[] mao = jogador.getMao();

                if (manaMaximaJogador1 > 0) {
                    for (int i = 0; i < mao.length; i++) {
                        if (mao[i] instanceof Mana) {
                            for (int j = 0; j < campoJogador1[1].length; j++) {
                                if (campoJogador1[1][j] == null) {
                                    campoJogador1[1][j] = mao[i];
                                    mao[i] = null;
                                    manaMaximaJogador1--;
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < mao.length; i++) {
                    if (mao[i] != null) {
                        for (int j = 0; j < campoJogador1[1].length; j++) {
                            if (campoJogador1[1][j] == null) {
                                campoJogador1[1][j] = mao[i];
                                mao[i] = null;
                                break;
                            }
                        }
                    }
                }

                jogador.setMao(mao);
            }
        } else if (jogador == jogador2) {
            if (jogador.getMao().length > 0) {
                Carta[] mao = jogador.getMao();

                if (manaMaximaJogador2 > 0) {
                    for (int i = 0; i < mao.length; i++) {
                        if (mao[i] instanceof Mana) {
                            for (int j = 0; j < campoJogador2[1].length; j++) {
                                if (campoJogador2[1][j] == null) {
                                    campoJogador2[1][j] = mao[i];
                                    mao[i] = null;
                                    manaMaximaJogador2--;
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < mao.length; i++) {
                    if (mao[i] != null) {
                        for (int j = 0; j < campoJogador2[1].length; j++) {
                            if (campoJogador2[1][j] == null) {
                                campoJogador2[1][j] = mao[i];
                                mao[i] = null;
                                break;
                            }
                        }
                    }
                }

                jogador.setMao(mao);
            }
        }
    }

    private void ataque(Usuario jogadorAtacante, Usuario jogadorDefensor) {
        Carta[][] campoAtacante = jogadorAtacante == jogador1 ? campoJogador1 : campoJogador2;
        Carta[][] campoDefensor = jogadorDefensor == jogador1 ? campoJogador1 : campoJogador2;
    
        for (int i = 0; i < campoAtacante[0].length; i++) {
            Carta cartaAtacante = campoAtacante[0][i];
            Carta cartaDefensor = campoDefensor[0][i];
    
            if (cartaAtacante != null) {
                if (cartaDefensor == null) {
                    // Se não houver carta defensora, aplique o dano diretamente ao jogador defensor
                    jogadorDefensor.setVida(jogadorDefensor.getVida() - cartaAtacante.getDano());
                } else {
                    // Caso contrário, calcule o resultado da batalha
                    int danoAtaque = cartaAtacante.getDano();
                    int danoDefesa = cartaDefensor.getDefesa();
    
                    if (danoAtaque > danoDefesa) {
                        // Atacante vence a batalha e inflige dano ao defensor
                        int danoCausado = danoAtaque - danoDefesa;
                        jogadorDefensor.setVida(jogadorDefensor.getVida() - danoCausado);
                    } else if (danoDefesa > danoAtaque) {
                        // Defensor vence a batalha e inflige dano ao atacante
                        int danoCausado = danoDefesa - danoAtaque;
                        jogadorAtacante.setVida(jogadorAtacante.getVida() - danoCausado);
                    }
                    // Em caso de empate, ninguém sofre dano.
                }
            }
        }
    }
    
}
