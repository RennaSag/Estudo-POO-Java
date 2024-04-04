package com.mycompany.projetoloja;

import java.util.List;
import java.util.Scanner;

/* autoria do mais brabo, the legend of Rennã Sag */

public class ProjetoLoja {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        LojaOnline loja = new LojaOnline();

        do {
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Consultar Produtos");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Consultar Clientes");
            System.out.println("0 - Sair");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de produto");
                    // Código para cadastrar produto
                    break;

                case 2:
                    System.out.println("Consulta de Produtos:");
                    List<Produto> produtos = loja.listarProdutos();
                    for (Produto produto : produtos) {
                        System.out.println(produto.getNome() + " - R$" + produto.getPreco());
                    }
                    break;

                case 3:
                    System.out.println("Cadastro de clientes");
                    // Código para cadastrar cliente
                    break;

                case 4:
                    System.out.println("Consulta de Clientes:");
                    List<Cliente> clientes = loja.listarClientes();
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getNome() + " - " + cliente.getEmail());
                    }
                    break;
            }
        } while (opcao != 0);
    }
}

//projeto em repositorio no github

//Corrigido erros de swicth case e na listagem dos itens