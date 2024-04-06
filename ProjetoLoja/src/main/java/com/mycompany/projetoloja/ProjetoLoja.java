package com.mycompany.projetoloja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* autoria do mais brabo, the legend of Rennã Sag */

public class ProjetoLoja {

    static Scanner ler = new Scanner(System.in);



    public static void main(String[] args) {
        int opcao;
        LojaOnline loja = new LojaOnline();
        List<Cliente> cli = loja.listarClientes();
        List<Produto> produtos = loja.listarProdutos();
        List<Produto> produtosPedido = new ArrayList<>();

        do {
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Consultar Produtos");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Consultar Clientes");
            System.out.println("5 - Realizar Pedido:");
            System.out.println("0 - Sair");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    //cadastro de produtos
                    System.out.println("Cadastro de produto");
                    Produto novoProduto = new Produto();

                    System.out.println("Insira o ID do produto:");
                    int idProduto = ler.nextInt();
                    novoProduto.setId(idProduto);

                    System.out.println("Insira o Nome do produto:");
                    String nomeProduto = ler.next();
                    novoProduto.setNome(nomeProduto);

                    System.out.println("Insira o Preco do produto:");
                    double precoProduto = ler.nextDouble();
                    novoProduto.setPreco(precoProduto);

                    System.out.println("Insira a Descricao do produto:");
                    String descricaoProduto = ler.next();
                    novoProduto.setDescricao(descricaoProduto);

                    //comando que estava em falta
                    loja.adicionarProduto(novoProduto);
                    break;

                case 2:
                    //mostrar produtos
                    System.out.println("Consulta de Produtos:");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto produto : produtos) {
                            System.out.println("ID: "+ produto.getId() +" Nome: " + produto.getNome() + " Preco: R$" + produto.getPreco());
                        }
                    }
                    break;

                case 3:
                    //cadastro de clientes
                    System.out.println("Cadastro de clientes");
                    Cliente novoCliente = new Cliente();

                    System.out.println("Insira o ID do cliente:");
                    int idCliente = ler.nextInt();
                    novoCliente.setId(idCliente);

                    System.out.println("Insira o Nome do cliente:");
                    String nomeCliente = ler.next();
                    novoCliente.setNome(nomeCliente);

                    System.out.println("Insira o Email do cliente:");
                    String emailCliente = ler.next();
                    novoCliente.setEmail(emailCliente);

                    System.out.println("Insira o Endereco do cliente:");
                    String enderecoCliente = ler.next();
                    novoCliente.setEndereco(enderecoCliente);


                    /*assim como no case 1, falatava adicionar de fato um novo cliente
                    na lista*/
                    loja.adicionarCliente(novoCliente);
                    break;

                case 4:
                    System.out.println("Consulta de Clientes:");
                    if (cli.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        for (Cliente cliente : cli) {
                            System.out.println("ID: "+ cliente.getId() +" Nome: " + cliente.getNome() + " Email: " + cliente.getEmail());
                        }
                    }
                    break;

                case 5:
                    //realizar pedido
                    System.out.println("Realizar Pedido:");
                    Pedido novoPedido = new Pedido();

                    System.out.println("Insira o ID do pedido: ");
                    int idPedido = ler.nextInt();
                    novoPedido.setId(idPedido);

                    if (cli.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    } else {
                        //mostrar ao usuario a lista dos clientes disponiveis para escolher qual vai fazer o pedido
                        for (Cliente cliente : cli) {
                            System.out.println("Clientes disponiveis: ");
                            System.out.println("Id: " + cliente.getId() + " Nome: " + cliente.getNome());
                        }
                    }

                    System.out.println("Insira o ID do cliente:");
                    int idClientePedido = ler.nextInt();
                    Cliente clientePedido = null;
                    for (Cliente cliente : cli) {
                        if (cliente.getId() == idClientePedido) {
                            clientePedido = cliente;
                            break;
                        }
                    }
                    if (clientePedido == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    novoPedido.setCliente(clientePedido);

                    System.out.println("Produtos disponiveis: ");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    } else {
                        for (Produto produto : produtos) {
                            System.out.println("ID: " + produto.getId() + " Nome: " + produto.getNome());
                        }
                    }


                    int opcionador;
                    do {
                        System.out.println("Insira o ID do produto: ");
                        int idProdutoPedido = ler.nextInt();
                        Produto produtoPedido = null;
                        for (Produto produto : produtos) {
                            if (produto.getId() == idProdutoPedido) {
                                produtoPedido = produto;
                                break;
                            }
                        }
                        if (produtoPedido == null) {
                            System.out.println("Produto não encontrado.");
                            break;
                        }
                        produtosPedido.add(produtoPedido);

                        System.out.println("Deseja adicionar mais produtos? (1:Sim/2:Nao)");
                        opcionador = ler.nextInt();
                    } while (opcionador != 2);

                    novoPedido.setProdutos(produtosPedido);

                    //finalizar e adicionar o pedido
                    loja.realizarPedido(clientePedido, produtosPedido);
                    break;


            }
        } while (opcao != 0);
    }
}

//projeto em repositorio no github

//adicionado o case 5 para realizar pedidos