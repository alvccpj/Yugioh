import java.util.Random;

public class Loja {
    private String numeroCartao;
    private String codigoVerificador;

    public Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

    public void compraDeBooster(Usuario usuario, Inventario Inventario) {
        int precoBooster = 10; // Preço do booster em cardcoins (ajuste conforme necessário)

        if (usuario.getCardcoinsUsuario() >= precoBooster) {
            usuario.setCardcoinsUsuario(usuario.getCardcoinsUsuario() - precoBooster);

            Inventario inventario = usuario.getInventario();
            Carta[] boosterPack = gerarCartaAleatoria();

            for (Carta cartaAleatoria : boosterPack) {
                adicionarCartaAoInventario(inventario, cartaAleatoria, usuario, inventario);
            }

            System.out.println("BOOSTER COMPRADO COM SUCESSO!!");
        } else {
            System.out.println("VOCÊ NÃO TEM CARDCOINS SUFICIENTES PARA COMPRAR O BOOSTER!");
        }
    }

    public Carta[] gerarCartaAleatoria(Carta carta) {
        int qtdCardsBoosterPack = 12;
        Carta[] boosterPack = new Carta[qtdCardsBoosterPack];

        for (int posBoosterPack = 0; posBoosterPack < qtdCardsBoosterPack; posBoosterPack++) {
            boosterPack[posBoosterPack] = carta;
            
        }
        return boosterPack;
    }
    public void adicionarCartaAoInventario(Inventario inventario, Carta carta, Usuario usuario) {
    int limiteCartasRepetidas = 3; // Limite de cartas repetidas permitidas

    // Verificar se o usuário já possui o limite de cartas repetidas da mesma carta
    int quantidadeCartaNoInventario = usuario.getInventario().contarCartasIguais(carta);
    if (quantidadeCartaNoInventario < limiteCartasRepetidas) {
        // Adicionar a carta ao inventário
        inventario.adicionarCartaAoInventario(carta);

        System.out.println("Carta Adicionada ao Inventario: " + carta.getNomeCarta());
    } else {
        // O usuário já possui o limite de cartas repetidas, ganhar Cardacoins
        int valorCartasRepetidas = calcularValorCartasRepetidas(carta, quantidadeCartaNoInventario);
        usuario.setCardcoinsUsuario(usuario.getCardcoinsUsuario() + valorCartasRepetidas);
        System.out.println("Você já possui o limite de cartas repetidas. Ganhou " + valorCartasRepetidas + " Cardacoins.");
    }
}

}