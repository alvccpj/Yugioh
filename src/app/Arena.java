package app;

import exceptions.IrregularDeckException;

import java.util.Random;

public class Arena {
    protected Usuario jogador1;
    protected Usuario jogador2;
    protected Deck deckJogador1;
    protected Deck deckJogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private Carta[] maoJogador1;
    private Carta[] maoJogador2;
    private int manaMaximaJogador1;
    private int manaMaximaJogador2;
    protected Carta[] cemiterioJogador1;
    protected Carta[] cemiterioJogador2;
    private boolean turnoJogador1;

    public Arena(Usuario jogador1, Usuario jogador2, Deck deckJogador1, Deck deckJogador2, Carta[][] campoJogador1, Carta[][] campoJogador2, Carta[] maoJogador1, Carta[] maoJogador2, int manaMaximaJogador1, int manaMaximaJogador2, Carta[] cemiterioJogador1, Carta[] cemiterioJogador2, boolean turnoJogador1) throws IrregularDeckException {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        if (deckJogador1 == null || deckJogador1.getTamanho() == 0 || deckJogador2 == null || deckJogador2.getTamanho() == 0) {
            throw new IrregularDeckException("Os decks de jogadores devem ser válidos.");
        }
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.maoJogador1 = new Carta[10];
        this.maoJogador2 = new Carta[10];
        this.manaMaximaJogador1 = 0;
        this.manaMaximaJogador2 = 0;
        this.cemiterioJogador1 = new Carta[100];
        this.cemiterioJogador2 = new Carta[100];
        this.turnoJogador1 = false;
    }

    public Arena(Usuario jogador1, Usuario jogador2) {
    }

    public Usuario getJogador1() {
        return jogador1;
    }

    public void setJogador1(Usuario jogador1) {
        this.jogador1 = jogador1;
    }

    public Usuario getJogador2() {
        return jogador2;
    }

    public void setJogador2(Usuario jogador2) {
        this.jogador2 = jogador2;
    }

    public Deck getDeckJogador1() {
        return deckJogador1;
    }

    public void setDeckJogador1(Deck deckJogador1) {
        this.deckJogador1 = deckJogador1;
    }

    public Deck getDeckJogador2() {
        return deckJogador2;
    }

    public void setDeckJogador2(Deck deckJogador2) {
        this.deckJogador2 = deckJogador2;
    }

    public Carta[][] getCampoJogador1() {
        return campoJogador1;
    }

    public void setCampoJogador1(Carta[][] campoJogador1) {
        this.campoJogador1 = campoJogador1;
    }

    public Carta[][] getCampoJogador2() {
        return campoJogador2;
    }

    public void setCampoJogador2(Carta[][] campoJogador2) {
        this.campoJogador2 = campoJogador2;
    }


    public Carta[] getMaoJogador1() {
        return maoJogador1;
    }

    public void setMaoJogador1(Carta[] maoJogador1) {
        this.maoJogador1 = maoJogador1;
    }

    public Carta[] getMaoJogador2() {
        return maoJogador2;
    }

    public void setMaoJogador2(Carta[] maoJogador2) {
        this.maoJogador2 = maoJogador2;
    }

    public int getManaMaximaJogador1() {
        return manaMaximaJogador1;
    }

    public void setManaMaximaJogador1(int manaMaximaJogador1) {
        this.manaMaximaJogador1 = manaMaximaJogador1;
    }

    public int getManaMaximaJogador2() {
        return manaMaximaJogador2;
    }

    public void setManaMaximaJogador2(int manaMaximaJogador2) {
        this.manaMaximaJogador2 = manaMaximaJogador2;
    }

    public Carta[] getCemiterioJogador1() {
        return cemiterioJogador1;
    }

    public void setCemiterioJogador1(Carta[] cemiterioJogador1) {
        this.cemiterioJogador1 = cemiterioJogador1;
    }

    public Carta[] getCemiterioJogador2() {
        return cemiterioJogador2;
    }

    public void setCemiterioJogador2(Carta[] cemiterioJogador2) {
        this.cemiterioJogador2 = cemiterioJogador2;
    }

    public boolean isTurnoJogador1() {
        return turnoJogador1;
    }

    public void setTurnoJogador1(boolean turnoJogador1) {
        this.turnoJogador1 = turnoJogador1;
    }

    public void iniciar() {
        sortearPrimeiroJogador();
        while (jogador1.getPontosVida() > 0 && jogador2.getPontosVida() > 0) {
            turno(jogador1, cemiterioJogador1);
            trocarTurno();
        }
        declararVencedor();
    }

    public void sortearPrimeiroJogador() {
        Random random = new Random();
        turnoJogador1 = random.nextBoolean();
    }


    public void turno(Usuario jogador, Carta[] mao) {
        saque(jogador, mao);
        compra(jogador);
        posicionamento(jogador, campoJogador1);
    }

    public void posicionamento(Usuario jogador, Carta[][] campo) {
        if (jogador == jogador1) {
            if (jogador.getManaAtual() > 0) {
                campo[0][0] = new Mana("Mana Genérica", "imagem", "Comum", 1, 1);
                jogador.setManaAtual(jogador.getManaAtual() - 1);
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

    public void realizarTurnoPublic(Usuario jogadorAtacante, Usuario jogadorDefensor, Carta[] mao) {
        realizarTurno(jogadorAtacante, jogadorDefensor, mao);
    }

    private void realizarTurno(Usuario jogadorAtacante, Usuario jogadorDefensor, Carta[] mao) {
        saque(jogadorAtacante, mao);
        compra(jogadorAtacante);
        posicionamento(jogadorAtacante, campoJogador1);
    }

    public void compra(Usuario jogador) {
        if (jogador == jogador1 && deckJogador1 != null && deckJogador1.getTamanho() > 0) {
            jogador.setManaMaxima(jogador.getManaMaxima() + 1);
        } else if (jogador == jogador2 && deckJogador2 != null && deckJogador2.getTamanho() > 0) {
            jogador.setManaMaxima(jogador.getManaMaxima() + 1);
        }
    }

    public void saque(Usuario jogador, Carta[] mao) {
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

    public void trocarTurno() {
        turnoJogador1 = !turnoJogador1;
    }

    public void declararVencedor() {
        if (jogador1.getPontosVida() <= 0) {
            getJogador2().adicionarCardCoins(100);
            getJogador1().adicionarCardCoins(10);
        } else if (jogador2.getPontosVida() <= 0) {
            getJogador1().adicionarCardCoins(100);
            getJogador2().adicionarCardCoins(10);
        }
    }
}



