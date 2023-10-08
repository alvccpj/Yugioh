import java.util.ArrayList;
import java.util.Random;

public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int vidaJogador1;
    private int vidaJogador2;
    private boolean jogoEncerrado;
    
    private int manaMaximaJogador1;
    private int manaMaximaJogador2;
    private ArrayList<Carta> cemiterioJogador1;
    private ArrayList<Carta> cemiterioJogador2;

    public Arena(Usuario jogador1, Usuario jogador2, String modalidadeJogo) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.vidaJogador1 = 20;
        this.vidaJogador2 = 20;
        this.jogoEncerrado = false;
        this.campoJogador1 = new Carta[10];
        this.campoJogador2 = new Carta[10];
        this.manaMaximaJogador1 = 0;
        this.manaMaximaJogador2 = 0;
        this.cemiterioJogador1 = new ArrayList<>();
        this.cemiterioJogador2 = new ArrayList<>();
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

    public void saque(Usuario jogador) {
        Random random = new Random();
        Carta[] deck = jogador.getDeck();
        ArrayList<Carta> cartasAleatorias = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            int indiceCarta = random.nextInt(deck.length);
            Carta carta = deck[indiceCarta];

            if (carta != null) {
                cartasAleatorias.add(carta);
                deck[indiceCarta] = null;
            }
        }

        jogador.setDeck(deck);
        jogador.setMao(cartasAleatorias.toArray(new Carta[0]));
    }

    public void retornarCartasAoDeck(Usuario jogador, Carta[] cartas) {
        Carta[] mao = jogador.getMao();
        ArrayList<Carta> deck = new ArrayList<>();

        for (Carta carta : cartas) {
            if (carta != null) {
                deck.add(carta);
            }
        }

        jogador.setMao(new Carta[10]);

        for (int i = 0; i < mao.length; i++) {
            if (i < deck.size()) {
                mao[i] = deck.get(i);
            }
        }

        jogador.setDeck(mao);
    }
}
