package app;

import enumerates.Raridade;
import exceptions.InsuficientCoinException;
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

    public void compraDeBooster(Usuario usuario, Inventario inventario) throws InsuficientCoinException {
        int precoBooster = promocao ? 15 : 10;

        if (usuario.getCardcoinsUsuario() < precoBooster) {
            throw new InsuficientCoinException();
        }

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
    }

    public Carta[] gerarCartaAleatoria() {
        Carta[] booster = new Carta[5];

        for (int i = 0; i < 5; i++) {
            double chance = Math.random();

            Raridade raridade = obterRaridadePorChance(chance);
            booster[i] = criarCarta(raridade);
        }

        return booster;
    }

    private Raridade obterRaridadePorChance(double chance) {
        if (chance <= Raridade.COMUM.getProbabilidadeDrop()) {
            return Raridade.COMUM;
        } else if (chance <= Raridade.INCOMUM.getProbabilidadeDrop()) {
            return Raridade.INCOMUM;
        } else if (chance <= Raridade.RARA.getProbabilidadeDrop()) {
            return Raridade.RARA;
        } else if (chance <= Raridade.MUITO_RARA.getProbabilidadeDrop()) {
            return Raridade.MUITO_RARA;
        } else {
            return Raridade.EPICA;
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

    private Carta criarCarta(Raridade raridade) {
        return new Carta(raridade);
    }

}
