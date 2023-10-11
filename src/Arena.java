//import java.util.ArrayList;
//import java.util.Random;
//
//public class Arena {
//    private Usuario jogador1;
//    private Usuario jogador2;
//    private Carta[][] campoJogador1 = new Carta[2][5];
//    private Carta[][] campoJogador2 = new Carta[2][5];
//    ;
//    private int vidaJogador1 = 20;
//    private int vidaJogador2 = 20;
//    private boolean jogoEncerrado = false;
//    private Carta[] maoJogador1 = new Carta[10];
//    private Carta[] maoJogador2 = new Carta[10];
//    private int manaMaximaJogador1 = 0;
//    private int manaMaximaJogador2 = 0;
//    private ArrayList<Carta> cemiterioJogador1 = new ArrayList<>();
//    private ArrayList<Carta> cemiterioJogador2 = new ArrayList<>();
//
//    public Usuario getJogador1() {
//        return jogador1;
//    }
//
//    public void setJogador1(Usuario jogador1) {
//        this.jogador1 = jogador1;
//    }
//
//    public Usuario getJogador2() {
//        return jogador2;
//    }
//
//    public void setJogador2(Usuario jogador2) {
//        this.jogador2 = jogador2;
//    }
//
//    public Carta[][] getCampoJogador1() {
//        return campoJogador1;
//    }
//
//    public void setCampoJogador1(Carta[][] campoJogador1) {
//        this.campoJogador1 = campoJogador1;
//    }
//
//    public Carta[][] getCampoJogador2() {
//        return campoJogador2;
//    }
//
//    public void setCampoJogador2(Carta[][] campoJogador2) {
//        this.campoJogador2 = campoJogador2;
//    }
//
//    public int getVidaJogador1() {
//        return vidaJogador1;
//    }
//
//    public void setVidaJogador1(int vidaJogador1) {
//        this.vidaJogador1 = vidaJogador1;
//    }
//
//    public int getVidaJogador2() {
//        return vidaJogador2;
//    }
//
//    public void setVidaJogador2(int vidaJogador2) {
//        this.vidaJogador2 = vidaJogador2;
//    }
//
//    public boolean isJogoEncerrado() {
//        return jogoEncerrado;
//    }
//
//    public void setJogoEncerrado(boolean jogoEncerrado) {
//        this.jogoEncerrado = jogoEncerrado;
//    }
//
//    public Carta[] getMaoJogador1() {
//        return maoJogador1;
//    }
//
//    public void setMaoJogador1(Carta[] maoJogador1) {
//        this.maoJogador1 = maoJogador1;
//    }
//
//    public Carta[] getMaoJogador2() {
//        return maoJogador2;
//    }
//
//    public void setMaoJogador2(Carta[] maoJogador2) {
//        this.maoJogador2 = maoJogador2;
//    }
//
//    public int getManaMaximaJogador1() {
//        return manaMaximaJogador1;
//    }
//
//    public void setManaMaximaJogador1(int manaMaximaJogador1) {
//        this.manaMaximaJogador1 = manaMaximaJogador1;
//    }
//
//    public int getManaMaximaJogador2() {
//        return manaMaximaJogador2;
//    }
//
//    public void setManaMaximaJogador2(int manaMaximaJogador2) {
//        this.manaMaximaJogador2 = manaMaximaJogador2;
//    }
//
//    public ArrayList<Carta> getCemiterioJogador1() {
//        return cemiterioJogador1;
//    }
//
//    public void setCemiterioJogador1(ArrayList<Carta> cemiterioJogador1) {
//        this.cemiterioJogador1 = cemiterioJogador1;
//    }
//
//    public ArrayList<Carta> getCemiterioJogador2() {
//        return cemiterioJogador2;
//    }
//
//    public void setCemiterioJogador2(ArrayList<Carta> cemiterioJogador2) {
//        this.cemiterioJogador2 = cemiterioJogador2;
//    }
//
//    public Arena(Usuario jogador1, Usuario jogador2) {
//        this.jogador1 = jogador1;
//        this.jogador2 = jogador2;
//    }
//
//    public void iniciarJogo() {
//        System.out.println("Iniciando partida entre " + jogador1.getUsuario() + " e " + jogador2.getUsuario());
//        while (!jogoEncerrado) {
//            regraJogo();
//        }
//    }
//
//    private void regraJogo() {
//        // Etapa 1: O jogador da vez faz seu turno
//        fazerTurno(jogador1); // Primeiro jogador
//        fazerTurno(jogador2); // Segundo jogador
//
//        // Etapa 2: Verificar condições de vitória ou empate
//        if (vidaJogador1 <= 0 || vidaJogador2 <= 0) {
//            jogoEncerrado = true;
//            finalizarJogo();
//        }
//    }
//
//    private void fazerTurno(Usuario jogador) {
//        // Etapa 1: O jogador compra uma carta
//        saque(jogador);
//
//        // Etapa 2: O jogador joga suas cartas e executa ações (implemente essa parte)
//
//        Carta[] mao = jogador.getMao();
//        if (mao.length > 0) {
//            // Suponha que o jogador jogue a primeira carta da mão (índice 0)
//            Carta cartaJogada = mao[0];
//
//            if (cartaJogada != null) {
//                // Execute a ação da carta (você precisará implementar essa lógica)
//                executarAcaoDaCarta(jogador, cartaJogada);
//
//                // Remova a carta da mão do jogador (defina-a como nula)
//                mao[0] = null;
//
//                // Atualize a mão do jogador
//                jogador.setMao(mao);
//            }
//        }
//
//        // Etapa 3: O jogador ataca o oponente (exemplo básico: reduz a vida do oponente)
//        if (jogador == jogador1) {
//            // Suponha que jogador1 ataca jogador2
//            atacar(jogador1, jogador2);
//        } else {
//            // Suponha que jogador2 ataca jogador1
//            atacar(jogador2, jogador1);
//        }
//
//        // Etapa 4: O jogador encerra seu turno e passa para o próximo
//        if (jogador == jogador1) {
//            // É o turno do jogador 2 agora
//            jogador = jogador2;
//        } else {
//            // É o turno do jogador 1 agora
//            jogador = jogador1;
//        }
//    }
//
//    private void finalizarJogo() {
//        if (vidaJogador1 <= 0) {
//            System.out.println(jogador2.getUsuario() + " venceu!");
//        } else if (vidaJogador2 <= 0) {
//            System.out.println(jogador1.getUsuario() + " venceu!");
//        } else {
//            System.out.println("O jogo terminou em empate!");
//        }
//    }
//
//}
