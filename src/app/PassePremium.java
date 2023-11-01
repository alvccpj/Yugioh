package app;
public class PassePremium extends Progresso {
    private int niveisGanhos;

    public int getNiveisGanhos() {
        return niveisGanhos;
    }

    public void setNiveisGanhos(int niveisGanhos) {
        this.niveisGanhos = niveisGanhos;
    }

    public PassePremium() {
        super();
        niveisGanhos = 0;
    }

    @Override
    public void entregarPremiacao() {
        if (niveisGanhos < premiacoes.length) {
            if ((niveisGanhos + 1) % 5 == 0) {
                premiacoes[niveisGanhos] = new String("Booster Especial");
            } else {
                // Booster comum para outros níveis
                premiacoes[niveisGanhos] = new String("Booster Comum");
            }

            niveisGanhos += 2;
        }
    }

    @Override
    public void progresso() {
        if (niveisGanhos < premiacoes.length) {
            System.out.println("Níveis ganhos: " + niveisGanhos);
        } else {
            System.out.println("Passe Premium concluído. Todos os níveis foram alcançados.");
            reiniciarPasse();
        }
    }

    private void reiniciarPasse() {
        for (int i = 0; i < premiacoes.length; i++) {
            premiacoes[i] = null;
        }
        niveisGanhos = 0;
        premiacaoAtual = 0;
    }
}
