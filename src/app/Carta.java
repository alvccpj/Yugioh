package app;

import enumerates.Raridade;
import interfaces.AtivacaoCarta;

public class Carta implements AtivacaoCarta {
    private String nomeCarta;
    private String imagem;
    private String tipo;
    private String raridade;
    private int ataque;
    private int defesa;
    private int custo;
    private String habilidade;
    private int quantidade;
    private int manaDaCarta;

    public Carta(String nome, String imagem, String tipo, String raridade, int ataque, int defesa, int custo, String habilidade, int quantidade, int manaDaCarta) {
        this.nomeCarta = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        this.raridade = raridade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
        this.quantidade = quantidade;
        this.manaDaCarta = manaDaCarta;
    }

    public Carta(Raridade raridade) {
    }

    public String getNomeCarta() {
        return nomeCarta;
    }

    public void setNomeCarta(String nomeCarta) {
        this.nomeCarta = nomeCarta;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0 && (quantidade <= 3 || this.manaDaCarta != 0)) {
            this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("A quantidade deve estar entre 0 e 3, exceto para mana.");
        }
    }

    public int getManaDaCarta() {
        return manaDaCarta;
    }

    public void setManaDaCarta(int manaDaCarta) {
        this.manaDaCarta = manaDaCarta;
    }

    @Override
    public void ativacao() {
        if (habilidade != null) {
            System.out.println("Ativação da habilidade da carta: " + habilidade);
        } else {
            System.out.println("Carta sem habilidades.");
        }
    }
}