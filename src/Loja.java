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


}
