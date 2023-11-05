package app;
public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4) {
        super(jogador1, jogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
    }

    public Usuario getJogador3() {
        return jogador3;
    }

    public void setJogador3(Usuario jogador3) {
        this.jogador3 = jogador3;
    }

    public Usuario getJogador4() {
        return jogador4;
    }

    public void setJogador4(Usuario jogador4) {
        this.jogador4 = jogador4;
    }


    @Override
    public void turno(Usuario jogador, Carta[] mao) {
        saque(jogador, mao);
        compra(jogador);
        posicionamento(jogador, getCampoJogador1());
    }


    public void turno(Usuario jogador, Carta[] mao, Usuario jogadorAliado) {
        saque(jogador, mao);
        compra(jogador);
        posicionamento(jogador, getCampoJogador1());  
        Carta[] vetorAliado = jogadorAliado.getMao();
        for (int i = 0; i < vetorAliado.length; i++) {
            mao[i + 7] = vetorAliado[i];
        }
        Carta[] vetorInimigo = getJogador1().getMao();
        for (int i = 0; i < vetorInimigo.length; i++) {
            mao[i + 14] = vetorInimigo[i];
        }
    }

    @Override
    public void saque(Usuario jogador, Carta[] mao) {
        int maxCartasSaque = 7;

        if (jogador == getJogador1() || jogador == jogador3) {
            // Jogador 1 e Jogador 3
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
        } else if (jogador == getJogador2() || jogador == jogador4) {
            // Jogador 2 e Jogador 4
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

    @Override
    public void iniciar() {
        sortearPrimeiroJogador();
        while (jogador1.getPontosVida() > 0 && jogador2.getPontosVida() > 0 &&
                jogador3.getPontosVida() > 0 && jogador4.getPontosVida() > 0) {
            turno(getJogador1(), cemiterioJogador1);
            turno(jogador3, cemiterioJogador1);

            turno(getJogador2(), cemiterioJogador2);
            turno(jogador4, cemiterioJogador2);

            trocarTurno();
        }
        declararVencedor();
    }
}
