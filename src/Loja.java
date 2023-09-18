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

            System.out.println("BOOSTER COMPRADO COM SUCESSO!!");
        } else {
            System.out.println("VOCÊ NÃO TEM CARDCOINS SUFICIENTES PARA COMPRAR O BOOSTER!");
        }
    }

    public Carta[] gerarCartaAleatoria() {
        int qtdCardsBoosterPack = 12;
        Carta[] boosterPack = new Carta[qtdCardsBoosterPack];
        Random random = new Random();

        for (int posBoosterPack = 0; posBoosterPack < qtdCardsBoosterPack; posBoosterPack++) {
            String[] nomesCartas = { "Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5" };
            String nomeAleatorio = nomesCartas[random.nextInt(nomesCartas.length)];
            int ataqueAleatorio = random.nextInt(10) + 1;
            int defesaAleatoria = random.nextInt(10) + 1;
            int raridadeAleatoria = random.nextInt(5);

            boosterPack[posBoosterPack] = new Carta(nomeAleatorio, "imagem", "tipo",
                    getRaridadeString(raridadeAleatoria), ataqueAleatorio, defesaAleatoria, 0, "ability", 0, 0);
        }

        return boosterPack;
    }

    private String getRaridadeString(int raridade) {
        switch (raridade) {
            case 0:
                return "COMUM";
            case 1:
                return "INCOMUM";
            case 2:
                return "RARA";
            case 3:
                return "MUITO_RARA";
            case 4:
                return "EPICA";
            default:
                return null;
        }
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
            System.out.println(
                    "Você já possui o limite de cartas repetidas. Ganhou " + valorCartasRepetidas + " Cardacoins.");
        }
    }

    private int calcularValorCartasRepetidas(Carta carta) {

        return 10;
    }
}
