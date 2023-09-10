public class Usuario extends Inventario{
    private String user;
    private String cpf;
    private String senha;
    private int idade;
    private char sexo;
    private String email;
    private int nivel = 1;
    private Inventario inventario;
    private Deck decks[] = new Deck[5];
    private int cardcoinsUsuario = 0;

    public Usuario() {

    }

    public Usuario(String user, String cpf, String senha, int idade, char sexo, String email, int nivel, Inventario inventario, int cardcoins) {
        this.user = user;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.nivel = nivel;
        this.inventario = new Inventario();
        this.cardcoinsUsuario = cardcoins;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public int getCardcoinsUsuario() {
        return cardcoinsUsuario;
    }

    public void setCardcoinsUsuario(int cardcoinsUsuario) {
        this.cardcoinsUsuario = cardcoinsUsuario;
    }
}
