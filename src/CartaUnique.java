import java.util.Random;

public class CartaUnique extends Carta {
    private String habilidadeExtra;

    public CartaUnique(String nome, String imagem, String tipo, String raridade, int ataque, int defesa, int custo, String habilidade, int quantidade, int mana) {
        super(nome, imagem, tipo, raridade, ataque + 1, defesa + 1, custo, habilidade, quantidade, mana);
        this.habilidadeExtra =gerarHabilidadeAleatoria();
    }

    public String getHabilidadeExtra() {
        return habilidadeExtra;
    }

    public void setHabilidadeExtra(String habilidadeExtra) {
        this.habilidadeExtra = habilidadeExtra;
    }

    private String gerarHabilidadeAleatoria() {
        String[] habilidades = { "Rajada de fogo", "Golpe sombrio", "Tempestade elétrica" };
        Random random = new Random();
        int indiceHabilidade = random.nextInt(habilidades.length);
        return habilidades[indiceHabilidade];
    
    }
}
