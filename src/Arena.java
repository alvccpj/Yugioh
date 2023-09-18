public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int vidaJogador1;
    private int vidaJogador2;
    private boolean jogoEncerrado;

    public Arena(Usuario jogador1, Usuario jogador2, String modalidadeJogo) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.vidaJogador1 = 20;
        this.vidaJogador2 = 20;
        this.jogoEncerrado = false;
    }

    public void regraJogo() {
        vidaJogador1--;
        vidaJogador2--;

        if (vidaJogador1 <= 0 || vidaJogador2 <= 0) {
            jogoEncerrado = true;
            finalizarJogo();
        }
    }

    private void finalizarJogo() {
        if (vidaJogador1 <= 0) {
            System.out.println(jogador1.getUsuario() + " venceu!");
        } else if (vidaJogador2 <= 0) {
            System.out.println(jogador2.getUsuario() + " venceu!");
        }
    }

    public void iniciarJogo() {
        System.out.println("Iniciando partida entre " + jogador1.getUsuario() + " e " + jogador2.getUsuario());
        while (!jogoEncerrado) {
            regraJogo();
        }
    }
}
