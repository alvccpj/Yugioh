public abstract class Progresso {
    protected String[] premiacoes = new String[60];
    protected int premiacaoAtual;

    public Progresso() {
        for (int i = 0; i < premiacoes.length; i++) {
            premiacoes[i] = null;
        }
        premiacaoAtual = 0;
    }

    public abstract void entregarPremiacao();

    public abstract void progresso();
}
