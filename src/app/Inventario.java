package app;
public class Inventario {
    private Carta[] cartasInventario;
    private int nivelAtual;
    private int cardcoinsInventario;

    public Inventario(Carta[] cartasInventario, int nivelAtual, int cardcoinsInventario) {
        this.cartasInventario = new Carta[200];
        this.nivelAtual = 1;
        this.cardcoinsInventario = cardcoinsInventario;
    }

    public Inventario() {

    }

    public Carta[] getCartasInventario() {
        return cartasInventario;
    }

    public void setCartasInventario(Carta[] cartasInventario) {
        this.cartasInventario = cartasInventario;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public int getCardcoinsInventario() {
        return cardcoinsInventario;
    }

    public void setCardcoinsInventario(int cardcoinsInventario) {
        this.cardcoinsInventario = cardcoinsInventario;
    }

    public boolean removerCartaDoInventario(Carta carta) {
        if (carta != null) {
            for (int i = 0; i < cartasInventario.length; i++) {
                if (cartasInventario[i] != null && cartasInventario[i].equals(carta)) {
                    cartasInventario[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void adicionarCartaAoInventario(Carta carta) {
        if (carta != null) {
            for (int i = 0; i < cartasInventario.length; i++) {
                if (cartasInventario[i] == null) {
                    cartasInventario[i] = carta;
                    break;
                }
            }
        }
    }

    public void adicionarCartaAoCemiterio(Carta carta) {

    }


    public int contarCartasIguais(Carta carta) {
        if (carta != null) {
            int contador = 0;

            for (Carta cartaNoInventario : cartasInventario) {
                if (cartaNoInventario != null && cartaNoInventario.equals(carta)) {
                    contador++;
                }
            }

            return contador;
        } else {
            return 0;
        }
    }
}
