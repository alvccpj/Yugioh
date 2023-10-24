public class PasseComum extends Progresso {
    private int niveisGanhos;

    public int getNiveisGanhos() {
        return niveisGanhos;
    }

    public void setNiveisGanhos(int niveisGanhos) {
        this.niveisGanhos = niveisGanhos;
    }

    public PasseComum() {
        super();
        niveisGanhos = 0;
    }

    @Override
    public void entregarPremiacao() {
        if (premiacaoAtual < premiacoes.length) {
            premiacoes[premiacaoAtual] = new String("Booster Comum");
            premiacaoAtual++;
            niveisGanhos++;
        }
    }

    @Override
    public void progresso() {
        if (niveisGanhos < premiacoes.length) {
            System.out.println("Níveis ganhos: " + niveisGanhos);
        } else {
            System.out.println("Passe Comum concluído. Não há mais premiações a ganhar.");
        }
    }
}
