package app;
public class Usuario {
    private String usuario;
    private String cpf;
    private String senha;
    private int idade;
    private char sexo;
    private String email;
    private int nivel;
    private Inventario inventario;
    private Deck[] decks;
    private double cardcoinsUsuario;
    private int manaMaxima;
    private int manaAtual;
    private Carta[] mao;
    private int pontosVida;

    public Usuario(String usuario, String cpf, String senha, int idade, char sexo, String email, int nivel, Inventario inventario, double cardcoinsUsuario, Deck decks, int manaMaxima, int manaAtual, Carta[] mao, int pontosVida) {
        this.usuario = usuario;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.nivel = 1;
        this.inventario = new Inventario();
        this.cardcoinsUsuario = 0.0;
        this.decks = new Deck[5];
        this.manaMaxima = 0;
        this.manaAtual = 0;
        this.mao = new Carta[10];
        this.pontosVida = 20;
    }

    public Usuario() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Deck[] getDecks() {
        return decks;
    }

    public void setDecks(Deck[] decks) {
        this.decks = decks;
    }

    public double getCardcoinsUsuario() {
        return cardcoinsUsuario;
    }

    public void setCardcoinsUsuario(double cardcoinsUsuario) {
        this.cardcoinsUsuario = cardcoinsUsuario;
    }

    public int getManaAtual() {
        return manaAtual;
    }

    public void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
    }

    public Carta[] getMao() {
        return null;
    }

    public void setMao(Carta[] mao) {
        this.mao = mao;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public void adicionarDeck(Deck novoDeck) {
        for (int i = 0; i < decks.length; i++) {
            if (decks[i] == null) {
                decks[i] = novoDeck;
                break;
            }
        }
    }

    public boolean removerDeck(Deck deckParaRemover) {
        for (int i = 0; i < decks.length; i++) {
            if (decks[i] != null && decks[i].equals(deckParaRemover)) {
                decks[i] = null;
                return true;
            }
        }
        return false;
    }

    public void adicionarCardCoins(double valor) {
        this.cardcoinsUsuario += valor;
    }

    public void adicionarAoCemiterio(Carta carta) {
        this.inventario.adicionarCartaAoCemiterio(carta);
    }

    public void adicionarManaMaxima(int quantidade) {
        this.manaMaxima += quantidade;
    }

    public void adicionarManaAtual(int quantidade) {
        this.manaAtual += quantidade;
    }

    public void removerCartaDaMao(Carta carta) {
        for (int i = 0; i < mao.length; i++) {
            if (mao[i] == carta) {
                mao[i] = null;
                break;
            }
        }
    }

    public int devolverCartasAoDeck(Carta[] cartasDevolvidas, int quantidade) {
        if (cartasDevolvidas != null && quantidade > 0) {
            int cartasDevolvidasCount = 0;

            for (int i = 0; i < quantidade; i++) {
                if (cartasDevolvidas[i] != null) {

                    if (inventario.getCartasInventario().length < 200) {
                        inventario.adicionarCartaAoInventario(cartasDevolvidas[i]);
                        cartasDevolvidas[i] = null;
                        cartasDevolvidasCount++;
                    } else {
                        break;
                    }
                }
            }

            return cartasDevolvidasCount;
        }

        return 0;
    }

}
    


