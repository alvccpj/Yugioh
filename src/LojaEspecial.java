public class LojaEspecial extends Loja {
    public LojaEspecial(String numeroCartao, String codigoVerificador, boolean promocao) {
        super(numeroCartao, codigoVerificador, promocao);
    }

    @Override
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
        } else {
            System.out.println("Você não tem cardcoins suficientes para comprar o booster especial!");
        }
    }
}
