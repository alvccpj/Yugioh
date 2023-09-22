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

    public void compraDeBooster(Usuario usuario, Inventario inventario) {
        int precoBooster = 10; 

        if (usuario.getCardcoinsUsuario() >= precoBooster) {
            usuario.setCardcoinsUsuario(usuario.getCardcoinsUsuario() - precoBooster);

            Carta[] boosterPack = gerarCartaAleatoria();

            for (Carta cartaAleatoria : boosterPack) {
                adicionarCartaAoInventario(inventario, cartaAleatoria, usuario);
            }

            System.out.println("Booster comprado com sucesso!");
        } else {
            System.out.println("Você não tem cardcoins o suficiente para comprar o Booster!");
        }
    }

    public Carta[] gerarCartaAleatoria() {
        int qtdCardsBoosterPack = 12;
        Carta[] boosterPack = new Carta[qtdCardsBoosterPack];

        for (int posBoosterPack = 0; posBoosterPack < qtdCardsBoosterPack; posBoosterPack++) {
            //fazer ainda a logica
            boosterPack[posBoosterPack] = new Carta("Carta Aleatória " + (posBoosterPack + 1), "imagem", "tipo", "raridade", 2, 3, 5, "ability", 0, 0);
        }
        return boosterPack;
    }

    public void adicionarCartaAoInventario(Inventario inventario, Carta carta, Usuario usuario) {
        int limiteCartasRepetidas = 3; 

        int quantidadeCartaNoInventario = inventario.contarCartasIguais(carta);
        if (quantidadeCartaNoInventario < limiteCartasRepetidas) {
            inventario.adicionarCartaAoInventario(carta);

            System.out.println("Carta Adicionada ao Inventario: " + carta.getNomeCarta());
        } else {
            int valorCartasRepetidas = calcularValorCartasRepetidas(carta);
            usuario.setCardcoinsUsuario(usuario.getCardcoinsUsuario() + valorCartasRepetidas);
            System.out.println("Você já possui o limite de cartas repetidas. Ganhou " + valorCartasRepetidas + " Cardacoins.");
        }
    }

    private int calcularValorCartasRepetidas(Carta carta) {
        
        return 10; 
    }
}
