package com.mycompany.trabalhopoo2;
/**
 * @author Grupo 4
 */
class Pedido {
    private static final int MAX_ITENS = 20;
    private ItemMenu[] itens;
    private Cliente cliente;
    private double total;
    private String status;
    private int itemCount;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ItemMenu[MAX_ITENS];
        this.total = 0.0;
        this.status = "Aguardando itens";
        this.itemCount = 0;
    }

    public void adicionarItem(ItemMenu item) {
        if (itemCount == MAX_ITENS) {
            System.out.println("Não é possível adicionar mais itens :( O pedido já contém o máximo de itens permitido...");
            return;
        }
        itens[itemCount++] = item;
        calcularTotal();
        
        if (itemCount == 1) {
            atualizarStatus();
            System.out.println("Status do pedido: " + status);
        }
    }

    private void calcularTotal() {
        total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += itens[i].getPreco();
        }
    }

    public double getTotal() {
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getStatus() {
        return status;
    }

    public void finalizarPedido() {
        status = "Pronto para entrega";
    }

    public String visualizarPedido() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append(cliente.visualizarCliente()).append("\n");
        detalhes.append("Itens:\n");

        for (int i = 0; i < itemCount; i++) {
            detalhes.append(itens[i].getDetalhesItem()).append("\n");
        }

        if (itemCount > 1) {
            detalhes.append("Total: R$ ").append(String.format("%.2f", total)).append("\n");
        }

        detalhes.append("Status: ").append(status).append("\n");

        return detalhes.toString();
    }

    private void atualizarStatus() {
        status = "Em preparação";
    }
}
