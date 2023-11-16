package app;
import java.util.Random;

public class CartaUnique extends Carta {
    private String habilidadeExtra;
    private String habilidade1;
    private String habilidade2;

    public CartaUnique(String nome, String imagem, String tipo, String raridade, int ataque, int defesa, int custo, String habilidade, int quantidade, int mana, String habilidadeExtra, String habilidade1, String habilidade2) {
        super(nome, imagem, tipo, raridade, ataque + 1, defesa + 1, custo, habilidade, quantidade, mana);
        this.habilidadeExtra = habilidadeExtra;
        this.habilidade1 = habilidade1;
        this.habilidade2 = habilidade2;
        this.habilidade1 = gerarHabilidadeAleatoria();
    }

    public String getHabilidadeExtra() {
        return habilidadeExtra;
    }

    public void setHabilidadeExtra(String habilidadeExtra) {
        this.habilidadeExtra = habilidadeExtra;
    }

    private String gerarHabilidadeAleatoria() {
        String[] habilidades = {"Rajada de fogo", "Golpe sombrio", "Tempestade elétrica"};
        Random random = new Random();
        int indiceHabilidade = random.nextInt(habilidades.length);
        return habilidades[indiceHabilidade];
    }

    @Override
    public void ativacao() {
        if (habilidade1 != null) {
            System.out.println("Ativação da primeira habilidade da carta única: " + habilidade1);
        }
        if (habilidade2 != null) {
            System.out.println("Ativação da segunda habilidade da carta única: " + habilidade2);
        }
    }
}
