public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private Carta[][] campoJogador1 = new Carta[2][5];
    private Carta[][] campoJogador2 = new Carta[2][5];
    private int pontosVidaJogador1 = 20;
    private int pontosVidaJogador2 = 20;

    public Arena(Usuario jogador1, Usuario jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = jogador1.getDecks()[0]; // Supondo que o jogador escolheu o primeiro deck
        this.deckJogador2 = jogador2.getDecks()[0]; // Supondo que o jogador escolheu o primeiro deck
    }

    // Métodos para manipular o campo de cartas

    public void colocarCartaNoCampo(Carta carta, int linha, int coluna, Usuario jogador) {
        Carta[][] campo;
        if (jogador == jogador1) {
            campo = campoJogador1;
        } else if (jogador == jogador2) {
            campo = campoJogador2;
        } else {
            throw new IllegalArgumentException("Jogador inválido");
        }

        campo[linha][coluna] = carta;
    }

    public Carta[][] getCampoJogador1() {
        return campoJogador1;
    }

    public Carta[][] getCampoJogador2() {
        return campoJogador2;
    }

    // Métodos para manipular os pontos de vida

    public void causarDano(Usuario jogador, int dano) {
        if (jogador == jogador1) {
            pontosVidaJogador1 -= dano;
        } else if (jogador == jogador2) {
            pontosVidaJogador2 -= dano;
        } else {
            throw new IllegalArgumentException("Jogador inválido");
        }

        if (pontosVidaJogador1 <= 0 || pontosVidaJogador2 <= 0) {
            finalizarPartida();
        }
    }

    public int getPontosVidaJogador1() {
        return pontosVidaJogador1;
    }

    public int getPontosVidaJogador2() {
        return pontosVidaJogador2;
    }

    public void finalizarPartida() {
        if (pontosVidaJogador1 <= 0) {
            System.out.println("Jogador 1 venceu!");
        } else if (pontosVidaJogador2 <= 0) {
            System.out.println("Jogador 2 venceu!");
        }
    }
}
