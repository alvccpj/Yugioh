public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;
    private Carta[][] campoJogador3;
    private Carta[][] campoJogador4;
    private Carta[] maoJogador3;
    private Carta[] maoJogador4;

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4) {
        super(jogador1, jogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
    }

    @Override
    protected void turno() {
    }

}
