package com.mycompany.projetoloja;

import java.util.List;
import java.util.Scanner;

/* autoria do mais brabo, the legend of Rennã Sag */

public class ProjetoLoja {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        LojaOnline loja = new LojaOnline();

        do{
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Consultar Produtos");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Consultar Clientes");
            System.out.println("0 - Sair");
            opcao = ler.nextInt();

            switch (opcao){
                //cadastro de produtos
                case 1:
                    System.out.println("Cadastro de produto");
                    Produto novoProduto = new Produto();

                    System.out.println("Insira o ID do prduto:");
                    int idProduto = ler.nextInt();
                    novoProduto.setId(idProduto);

                    System.out.println(("Insira o nome do produto:"));
                    String nomeProduto = ler.next();
                    novoProduto.setNome(nomeProduto);

                    System.out.println("Insira o preco do produto:");
                    double precoProduto = ler.nextDouble();
                    novoProduto.setPreco(precoProduto);

                    System.out.println("Insira a descricao do produto:");
                    String descricaoProduto = ler.next();
                    novoProduto.setDescricao(descricaoProduto);


                case 2:
                    //consulta de produtos
                    System.out.println("Consulta de Produtos:");
                    List<Produto> produtos = loja.listarProdutos();
                    for (Produto produto : produtos) {
                        System.out.println(produto.getNome() + " - R$" + produto.getPreco());
                    }
                    break;


                case 3:
                    //cadastro de clientes
                    System.out.println("Cadastro de clientes");
                    Cliente novoCliente = new Cliente();

                    System.out.println("Insira o id do cliente:");
                    int idCliente = ler.nextInt();
                    novoCliente.setId(idCliente);

                    System.out.println("Insira o nome do cliente:");
                    String nomeCliente = ler.next();
                    novoCliente.setNome(nomeCliente);

                    System.out.println("Insira o email do cliente:");
                    String emailCliente = ler.next();
                    novoCliente.setEmail(emailCliente);

                    System.out.println("Insira o endereco do cliente:");
                    String enderecoCliente = ler.next();
                    novoCliente.setEmail(enderecoCliente);


                case 4:
                    //consulta de clientes
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


//faltando corrigir a parte de consulta de clientes e produtos, não ta aparecendo