import java.util.ArrayList;
import java.util.Random;

public class Arena {
    private Usuario jogador1;
    private Usuario jogador2;
    private Carta[][] campoJogador1 = new Carta[2][5];
    private Carta[][] campoJogador2 = new Carta[2][5];
    ;
    private int vidaJogador1 = 20;
    private int vidaJogador2 = 20;
    private boolean jogoEncerrado = false;
    private Carta[] maoJogador1 = new Carta[10];
    private Carta[] maoJogador2 = new Carta[10];
    private int manaMaximaJogador1 = 0;
    private int manaMaximaJogador2 = 0;
    private ArrayList<Carta> cemiterioJogador1 = new ArrayList<>();
    private ArrayList<Carta> cemiterioJogador2 = new ArrayList<>();

    public Usuario getJogador1() {
        return jogador1;
    }

    public void setJogador1(Usuario jogador1) {
        this.jogador1 = jogador1;
    }

    public Usuario getJogador2() {
        return jogador2;
    }

    public void setJogador2(Usuario jogador2) {
        this.jogador2 = jogador2;
    }

    public Carta[][] getCampoJogador1() {
        return campoJogador1;
    }

    public void setCampoJogador1(Carta[][] campoJogador1) {
        this.campoJogador1 = campoJogador1;
    }

    public Carta[][] getCampoJogador2() {
        return campoJogador2;
    }

    public void setCampoJogador2(Carta[][] campoJogador2) {
        this.campoJogador2 = campoJogador2;
    }

    public int getVidaJogador1() {
        return vidaJogador1;
    }

    public void setVidaJogador1(int vidaJogador1) {
        this.vidaJogador1 = vidaJogador1;
    }

    public int getVidaJogador2() {
        return vidaJogador2;
    }

    public void setVidaJogador2(int vidaJogador2) {
        this.vidaJogador2 = vidaJogador2;
    }

    public boolean isJogoEncerrado() {
        return jogoEncerrado;
    }

    public void setJogoEncerrado(boolean jogoEncerrado) {
        this.jogoEncerrado = jogoEncerrado;
    }

    public Carta[] getMaoJogador1() {
        return maoJogador1;
    }

    public void setMaoJogador1(Carta[] maoJogador1) {
        this.maoJogador1 = maoJogador1;
    }

    public Carta[] getMaoJogador2() {
        return maoJogador2;
    }

    public void setMaoJogador2(Carta[] maoJogador2) {
        this.maoJogador2 = maoJogador2;
    }

    public int getManaMaximaJogador1() {
        return manaMaximaJogador1;
    }

    public void setManaMaximaJogador1(int manaMaximaJogador1) {
        this.manaMaximaJogador1 = manaMaximaJogador1;
    }

    public int getManaMaximaJogador2() {
        return manaMaximaJogador2;
    }

    public void setManaMaximaJogador2(int manaMaximaJogador2) {
        this.manaMaximaJogador2 = manaMaximaJogador2;
    }

    public ArrayList<Carta> getCemiterioJogador1() {
        return cemiterioJogador1;
    }

    public void setCemiterioJogador1(ArrayList<Carta> cemiterioJogador1) {
        this.cemiterioJogador1 = cemiterioJogador1;
    }

    public ArrayList<Carta> getCemiterioJogador2() {
        return cemiterioJogador2;
    }

    public void setCemiterioJogador2(ArrayList<Carta> cemiterioJogador2) {
        this.cemiterioJogador2 = cemiterioJogador2;
    }

    public Arena(Usuario jogador1, Usuario jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public void iniciarJogo() {
        System.out.println("Iniciando partida entre " + jogador1.getUsuario() + " e " + jogador2.getUsuario());
        while (!jogoEncerrado) {
            regraJogo();
        }
    }

    private void regraJogo() {


    }
}
