public class Deck {
    private String nomeDeck;
    private Carta[] cartas;
    private boolean disponibilidade;

    public Deck(String nomeDeck, Carta[] cartas) {
        this.nomeDeck = nomeDeck;
        this.cartas = cartas;
        this.disponibilidade = false;
    }

    public String getNomeDeck() {
        return nomeDeck;
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void verificarDisponibilidade() {
        if (cartas.length >= 60 && verificarCartasRepetidas()) {
            disponibilidade = true;
        } else {
            disponibilidade = false;
        }
    }

    public boolean verificarCartasRepetidas() {
        for (int i = 0; i < cartas.length; i++) {
            Carta cartaAtual = cartas[i];

            if (!cartaAtual.getTipo().equalsIgnoreCase("mana")) {
                int quantidadeRepetida = 0;

                for (int j = i + 1; j < cartas.length; j++) {
                    if (cartaAtual.getNomeCarta().equalsIgnoreCase(cartas[j].getNomeCarta())) {
                        quantidadeRepetida++;
                    }
                }

                if (quantidadeRepetida > 2) {
                    return false;
                }
            }
        }

        return true;
    }

    public void adicionarCartaAoDeck(Carta carta, Inventario inventario) {
        if (carta != null && inventario.removerCartaDoInventario(carta)) {
            for (int i = 0; i < cartas.length; i++) {
                if (cartas[i] == null) {
                    cartas[i] = carta;
                    break;
                }
            }
        }
    }

    public void removerCartaDoDeck(Carta carta, Inventario inventario) {
        if (carta != null) {
            for (int i = 0; i < cartas.length; i++) {
                if (cartas[i] != null && cartas[i].equals(carta)) {
                    cartas[i] = null;
                    break;
                }
            }

            inventario.adicionarCartaAoInventario(carta);
        }
    }

    public Carta obterCartaAleatoria() {
    }
}
