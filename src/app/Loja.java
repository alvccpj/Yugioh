package app;
import java.util.Random;

public class Loja {
    private String numeroCartao;
    private String codigoVerificador;
    private boolean promocao;

    public Loja(String numeroCartao, String codigoVerificador, boolean promocao) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
        this.promocao = promocao;
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

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public void compraDeBooster(Usuario usuario, Inventario inventario) {
        int precoBooster = promocao ? 15 : 10;

        if (usuario.getCardcoinsUsuario() >= precoBooster) {
            usuario.setCardcoinsUsuario(usuario.getCardcoinsUsuario() - precoBooster);

            Carta[] boosterPack = gerarCartaAleatoria();

            for (Carta cartaAleatoria : boosterPack) {
                if (promocao) {
                    double chanceCartaUnica = Math.random();
                    if (chanceCartaUnica <= 0.01) {
                        cartaAleatoria = criarCartaUnica(cartaAleatoria);
                    }
                }
                adicionarCartaAoInventario(inventario, cartaAleatoria, usuario);
            }

            System.out.println("Booster comprado com sucesso!");
        } else {
            System.out.println("Você não tem cardcoins o suficiente para comprar o Booster!");
        }
    }


    public void BoosterEspecial(Usuario usuario, Inventario inventario) {
        int precoBoosterEspecial = 15;

        if (usuario.getCardcoinsUsuario() >= precoBoosterEspecial) {
            usuario.setCardcoinsUsuario(usuario.getCardcoinsUsuario() - precoBoosterEspecial);

            Carta[] boosterPack = gerarCartaAleatoria();

            for (Carta cartaAleatoria : boosterPack) {
                if (promocao) {
                    double chanceCartaUnica = Math.random();
                    if (chanceCartaUnica <= 0.01) {
                        cartaAleatoria = criarCartaUnica(cartaAleatoria);
                    }
                }
                adicionarCartaAoInventario(inventario, cartaAleatoria, usuario);
            }

            System.out.println("Booster especial comprado com sucesso!");
            System.out.println("Você não cardcoins suficientes para comprar o booster especial!");
        }
    }

    Carta criarCartaUnica(Carta cartaAleatoria) {
        return null;
    }

    public Carta[] gerarCartaAleatoria() {
        int qtdCardsBoosterPack = 12;
        Carta[] boosterPack = new Carta[qtdCardsBoosterPack];
        Random random = new Random();

        for (int posBoosterPack = 0; posBoosterPack < qtdCardsBoosterPack; posBoosterPack++) {
            String[] nomesCartas = {"Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5"};
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
                    "Você já possui o limite de cartas repetidas. Ganhou " + valorCartasRepetidas + " Cardcoins.");
        }
    }

    private int calcularValorCartasRepetidas(Carta carta) {
        return 10;
    }

}
