import java.util.Random;

public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;
    private Carta[] maoJogador1;
    private Carta[] maoJogador2;
    private int manaMaximaJogador1;
    private int manaMaximaJogador2;
    private Carta[] cemiterioJogador1 = new Carta[100];
    private Carta[] cemiterioJogador2 = new Carta[100];
    private boolean turnoJogador1;

    public Arena(Usuario jogador1, Usuario jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = null;
        this.deckJogador2 = null;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
        this.maoJogador1 = new Carta[10];
        this.maoJogador2 = new Carta[10];
        this.manaMaximaJogador1 = 0;
        this.manaMaximaJogador2 = 0;
        this.turnoJogador1 = false;
    }

    public void iniciar() {
        sortearPrimeiroJogador();
        while (pontosVidaJogador1 > 0 && pontosVidaJogador2 > 0) {
            turno();
            trocarTurno();
        }
        declararVencedor();
    }

    private void sortearPrimeiroJogador() {
        Random random = new Random();
        turnoJogador1 = random.nextBoolean();
    }

    private void turno() {
        if (turnoJogador1) {
            realizarTurno(jogador1, jogador2, maoJogador1);
        } else {
            realizarTurno(jogador2, jogador1, maoJogador2);
        }
    }
    private void posicionamento(Usuario jogador, Carta[][] campo) {
        if (jogador == jogador1) {
            if (jogador.getMana() > 0) {
                campo[0][0] = new Mana("Mana Genérica", "imagem", "Comum", 1, 1);
                jogador.setManaAtual(jogador.getMana() - 1); // Reduza a mana do jogador
            } else {
                for (Carta carta : jogador.getMao()) {
                    if (carta != null) {
                        if (carta instanceof Mana) {
                            continue; 
                        }
    
                        campo[1][0] = carta;
                        jogador.removerCartaDaMao(carta);
                        jogador.setManaMaxima(jogador.getManaMaxima() - carta.getMana());
                        break;
                    }
                }
            }
        } else if (jogador == jogador2) {
            
        }
    }
    
    
    
    
    private void realizarTurno(Usuario jogadorAtacante, Usuario jogadorDefensor, Carta[] mao) {
        saque(jogadorAtacante, mao);
        compra(jogadorAtacante);
        posicionamento(jogadorAtacante, campoJogador1); // Adicione esta linha
    }
    
    private void compra(Usuario jogador) {
        if (jogador == jogador1 && deckJogador1 != null && deckJogador1.getTamanho() > 0) {
            jogador.setManaMaxima(jogador.getManaMaxima() + 1);
        } else if (jogador == jogador2 && deckJogador2 != null && deckJogador2.getTamanho() > 0) {
        }
    }
    

    private void saque(Usuario jogador, Carta[] mao) {
        int maxCartasSaque = 7;

        if (jogador == jogador1) {

            if (deckJogador1 != null) {
                Carta[] cartasSaque = new Carta[maxCartasSaque];

                for (int i = 0; i < maxCartasSaque; i++) {
                    if (deckJogador1.getTamanho() > 0) {
                        cartasSaque[i] = deckJogador1.obterCartaAleatoria();
                    }
                }

                for (int i = 0; i < maxCartasSaque; i++) {
                    if (cartasSaque[i] != null) {
                        mao[i] = cartasSaque[i];
                    }
                }

                int cartasDevolvidas = jogador.devolverCartasAoDeck(cartasSaque, maxCartasSaque);

                if (cartasDevolvidas > 0) {
                    for (int i = 0; i < cartasDevolvidas; i++) {
                        if (deckJogador1 != null) {
                            int posicaoMao = i + maxCartasSaque;
                            mao[posicaoMao] = deckJogador1.obterCartaAleatoria();
                        }
                    }
                }
            }
        } else if (jogador == jogador2) {

            if (deckJogador2 != null) {
                Carta[] cartasSaque = new Carta[maxCartasSaque];

                for (int i = 0; i < maxCartasSaque; i++) {
                    if (deckJogador2.getTamanho() > 0) {
                        cartasSaque[i] = deckJogador2.obterCartaAleatoria();
                    }
                }

                for (int i = 0; i < maxCartasSaque; i++) {
                    if (cartasSaque[i] != null) {
                        mao[i] = cartasSaque[i];
                    }
                }

                int cartasDevolvidas = jogador.devolverCartasAoDeck(cartasSaque, maxCartasSaque);

                if (cartasDevolvidas > 0) {
                    for (int i = 0; i < cartasDevolvidas; i++) {
                        if (deckJogador2 != null) {
                            int posicaoMao = i + maxCartasSaque;
                            mao[posicaoMao] = deckJogador2.obterCartaAleatoria();
                        }
                    }
                }
            }
        }
    }

    private void trocarTurno() {
        turnoJogador1 = !turnoJogador1;
    }

    private void declararVencedor() {
        if (pontosVidaJogador1 <= 0) {

            jogador2.adicionarCardCoins(100);
            jogador1.adicionarCardCoins(10);
        } else if (pontosVidaJogador2 <= 0) {

            jogador1.adicionarCardCoins(100);
            jogador2.adicionarCardCoins(10);
        }

    }
}
