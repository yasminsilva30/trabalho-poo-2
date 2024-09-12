package com.mycompany.trabalhopoo2;
/**
 * @author Grupo 4
 */
class ItemMenu {
    private String nome;
    private String categoria;
    private double preco;

    public ItemMenu(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public String getDetalhesItem() {
        return nome + " (" + categoria + "): R$ " + String.format("%.2f", preco);
    }
}