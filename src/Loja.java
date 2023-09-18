public class Loja {
    private String numeroCartao;
    private String codigoVerificador;

    //constructor

    public Loja(String numeroCartao, String codigoVerificador){
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
    }

    //get e set

    public String getNumcartao() {
        return numeroCartao;
    }

    public void setNumcartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

    //metodos

    public void compraDeBooster(Usuario usuario) {
        
        int precoBooster = 10; //pode ser qualquer preco aqui

        if (usuario.getCardCoinsUsuario() >= precoBooster) {
            
            usuario.setCardCoins(usuario.getCardCoinsUsuario() - precoBooster); 

            Carta[] inventario = usuario.getInventario();
            for (int i = 0; i < 12; i++) {
                
                Carta cartaAleatoria = gerarCartaAleatoria();
                adicionarCartaAoInventario(inventario, cartaAleatoria);
            }

                System.out.println("BOOSTER COMPRADO COM SUCESSO!!");
        } 
        
            else {
                System.out.println("VOCÊ NÃO TEM CARDCOINS SUFICIENTES PARA COMPRAR O BOOSTER!");
        }
    }

    

}