package com.mycompany.trabalhopoo2;
/**
 * @author Grupo 4
 */
import java.util.Scanner;

public class Principal {
    private static Cliente[] clientes = new Cliente[10];
    private static ItemMenu[] menu = new ItemMenu[20];
    private static Pedido[] pedidos = new Pedido[12];
    private static Scanner scanner = new Scanner(System.in);
    private static int clienteIndex = 0;
    private static int pedidoIndex = 0;

    public static void main(String[] args) {
        inicializarMenu();

        Cliente cliente = cadastrarCliente();
        Pedido pedido = new Pedido(cliente);

        exibirMenu();

        while (true) {
            adicionarItemAoPedido(pedido);
        }
    }

    private static void inicializarMenu() {
        menu[1] = new ItemMenu("Pizza Frango c/ Catupiry", "Pizza", 30.00);
        menu[2] = new ItemMenu("Pizza 4 Queijos", "Pizza", 25.00);
        menu[3] = new ItemMenu("Pizza Calabresa", "Pizza", 28.00);
        menu[4] = new ItemMenu("Pizza Portuguesa", "Pizza", 32.00);
        menu[5] = new ItemMenu("Pizza Bacon c/ Ovos", "Pizza", 30.00);
        menu[6] = new ItemMenu("Pizza Marguerita", "Pizza", 29.00);

        menu[7] = new ItemMenu("Pizza Banana c/ Canela", "Pizza", 23.00);
        menu[8] = new ItemMenu("Pizza Chocolate", "Pizza", 25.00);
        menu[9] = new ItemMenu("Pizza Chocolate c/ Morango", "Pizza", 27.00);
        menu[10] = new ItemMenu("Pizza Nutella", "Pizza", 28.00);
        menu[11] = new ItemMenu("Pizza Prestígio", "Pizza", 27.00);

        menu[12] = new ItemMenu("Lata de Pepsi", "Bebida", 5.00);
        menu[13] = new ItemMenu("Lata de Coca-Cola", "Bebida", 5.00);
        menu[14] = new ItemMenu("Lata de Guaraná Jesus", "Bebida", 5.00);
        menu[15] = new ItemMenu("Lata de Guaraná Antartica", "Bebida", 5.00);
        menu[16] = new ItemMenu("Lata de Mineiro", "Bebida", 5.00);
        menu[17] = new ItemMenu("Garrafa 2L Pepsi", "Bebida", 9.00);
        menu[18] = new ItemMenu("Garrafa 2L Coca-Cola", "Bebida", 9.00);
        menu[19] = new ItemMenu("Garrafa 2L Mineiro", "Bebida", 9.00);
    }

    private static void exibirMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.println(i + ": " + menu[i].getDetalhesItem());
            }
        }
    }

    private static Cliente cadastrarCliente() {
        System.out.println("Bem-vindo a Pizzaria Popeyes!");
        System.out.println("Para realizarmos o pedido, por gentileza insira seus dados:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, telefone);
        clientes[clienteIndex++] = cliente;
        return cliente;
    }

    private static void adicionarItemAoPedido(Pedido pedido) {
        System.out.print("Insira o número do item para adicionar ao pedido (ou -1 para finalizar): \n");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == -1) {
            pedido.finalizarPedido();
            pedidos[pedidoIndex++] = pedido;
            System.out.println("\n Pedido finalizado com sucesso!");
            System.out.println(pedido.visualizarPedido());
            System.exit(0);
        }

        if (escolha >= 0 && escolha < menu.length && menu[escolha] != null) {
            pedido.adicionarItem(menu[escolha]);
        } else {
            System.out.println("Opção inválida :( tente novamente.");
        }
    }
}
