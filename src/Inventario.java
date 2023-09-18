public class Inventario {
    private Carta cartas[] = new Carta[200];
    private int nivelAtual;
    private int cardcoinsInventario;

    public Inventario() {
        this.cartas = cartas;
        this.nivelAtual = nivelAtual;
        this.cardcoinsInventario = cardcoinsInventario;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public int getCardcoinsUsuario() {
        return cardcoinsInventario;
    }

    public void setCardcoinsUsuario(int cardcoinsUsuario) {
        this.cardcoinsInventario = cardcoinsUsuario;
    }

    public boolean removerCartaDoInventario(Carta carta) {
        if (carta != null) {
            for (int i = 0; i < cartas.length; i++) {
                if (cartas[i] != null && cartas[i].equals(carta)) {
                    cartas[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void adicionarCartaAoInventario(Carta carta) {
        if (carta != null) {
            for (int i = 0; i < cartas.length; i++) {
                if (cartas[i] == null) {
                    cartas[i] = carta;
                    break;
                }
            }
        }
    }

    public int contarCartasIguais(Carta carta) {
        return 0;
    }
}
