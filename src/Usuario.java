public class Usuario {
    private String usuario;
    private String cpf;
    private String senha;
    private int idade;
    private char sexo;
    private String email;
    private int nivel = 1;
    private Inventario inventario;
    private Deck decks[] = new Deck[5];
    private double cardcoinsUsuario = 0.0;

    public Usuario(String usuario, String cpf, String senha, int idade, char sexo, String email, int nivel, Inventario inventario, double cardcoins) {
        this.usuario = usuario;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.nivel = nivel;
        this.inventario = new Inventario();
        this.cardcoinsUsuario = cardcoins;
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
                return true; // Deck removido com sucesso
            }
        }
        return false; // Deck não encontrado
    }

    public void setMao(Carta[] cartas) {

    }

    public Carta[] getMao() {
        return null;
    }

}
