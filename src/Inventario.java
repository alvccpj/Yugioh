public class Inventario extends Usuario{


    public Inventario(String user, String cpf, String senha, int idade, char sexo, String email, int nivel, Inventario inventario, int cardcoins) {
        super(user, cpf, senha, idade, sexo, email, nivel, inventario, cardcoins);
    }

    public Inventario() {
        super();
    }
}
