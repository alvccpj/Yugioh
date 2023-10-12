import java.util.ArrayList;
import java.util.Random;

public class ArenaDupla extends Arena {
    private Usuario jogador3;
    private Usuario jogador4;
    private Carta[][] campoJogador3 = new Carta[2][5];
    private Carta[][] campoJogador4 = new Carta[2][5];
    private ArrayList<Carta> cemiterioJogador3 = new ArrayList<>();
    private ArrayList<Carta> cemiterioJogador4 = new ArrayList<>();

    public ArenaDupla(Usuario jogador1, Usuario jogador2, Usuario jogador3, Usuario jogador4) {
        super(jogador1, jogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        jogador3.setMao(new Carta[10]);
        jogador4.setMao(new Carta[10]);
    }

    @Override
    public void iniciarJogo() {
        System.out.println("Iniciando partida entre " + jogador1.getUsuario() + ", " + jogador2.getUsuario() + ", " + jogador3.getUsuario() + " e " + jogador4.getUsuario());
        while (!jogoEncerrado) {
            regraJogo();
        }
    }

    @Override
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
                    deck.removeCarta(carta);
                    cartasRestantes--;
                }
            }
        }

        jogador.setDecks(decks);
        jogador.setMao(cartasAleatorias.toArray(new Carta[0]));

        if (jogador == jogador3 || jogador == jogador4) {
        }
    }

    @Override
    private void fazerTurno(Usuario jogador) {
        if (jogador == jogador1 || jogador == jogador2) {
            super.fazerTurno(jogador);
        } else {
        }
    }

}
