package app;
public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4) {
        super(jogador1, jogador2);
        this.jogador3 = jogador3;
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

    
}
