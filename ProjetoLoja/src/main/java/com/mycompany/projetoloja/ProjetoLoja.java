package com.mycompany.projetoloja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* autoria do mais brabo, the legend of Rennã Sag */

public class ProjetoLoja {





    public static void main(String[] args) {
        int opcao;
        Scanner ler = new Scanner(System.in);
        LojaOnline loja = new LojaOnline();

        do {
            System.out.println("Opcoes da loja: ");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Listar todos os clientes");
            System.out.println("5 - Realizar Pedido");
            System.out.println("6 - Remover produto");
            System.out.println("7 - Remover cliente");
            System.out.println("8 - Consultar produto");
            System.out.println("9 - Consultar cliente");
            System.out.println("0 - Sair");
            opcao = ler.nextInt();


            switch (opcao) {

                case 1:
                    Produto novoProduto = new Produto();
                    //cadastro de produtos
                    System.out.println("Cadastro de produto");
                    System.out.println("Insira o ID do produto:");
                    novoProduto.setId(ler.nextInt());


                    System.out.println("Insira o Nome do produto:");
                    novoProduto.setNome(ler.next());

                    System.out.println("Insira o Preco do produto:");
                    novoProduto.setPreco(ler.nextDouble());

                    System.out.println("Insira a Descricao do produto:");
                    novoProduto.setDescricao(ler.next());

                    //comando que estava em falta
                    loja.adicionarProduto(novoProduto);
                    break;

                case 2:
                    //mostrar produtos
                    System.out.println("Listagem de Produtos:");
                    if (loja.listarProdutos().isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto produto : loja.listarProdutos()) {
                            System.out.println("ID: "+ produto.getId() +" Nome: " + produto.getNome());
                        }
                    }
                    break;

                case 3:
                    //cadastro de clientes
                    System.out.println("Cadastro de clientes");
                    Cliente novoCliente = new Cliente();

                    System.out.println("Insira o ID do cliente:");
                    novoCliente.setId(ler.nextInt());

                    System.out.println("Insira o Nome do cliente:");
                    novoCliente.setNome(ler.next());

                    System.out.println("Insira o Email do cliente:");
                    novoCliente.setEmail(ler.next());

                    System.out.println("Insira o Endereco do cliente:");
                    novoCliente.setEndereco(ler.next());


                    /*assim como no case 1, falatava adicionar de fato um novo cliente
                    na lista*/
                    loja.adicionarCliente(novoCliente);
                    break;

                case 4:
                    System.out.println("Listagem de Clientes:");
                    if (loja.listarClientes().isEmpty()) {
                        System.out.println("Nenhum usuario cadastrado.");
                    } else {
                        for (Cliente cliente : loja.listarClientes()) {
                            System.out.println("ID: " + cliente.getId() + " Nome: " + cliente.getNome());
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

                    if (loja.listarClientes().isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    } else {
                        //mostrar ao usuario a lista dos clientes disponiveis para escolher qual vai fazer o pedido
                        for (Cliente cliente : loja.listarClientes()) {
                            System.out.println("Clientes disponiveis: ");
                            System.out.println("ID: " + cliente.getId() +"Nome: " + cliente.getNome());
                        }
                    }

                    System.out.println("Insira o ID do cliente:");
                    int idClientePedido = ler.nextInt();
                    Cliente clientePedido = null;
                    for (Cliente cliente : loja.listarClientes()) {
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
                    if (loja.listarProdutos().isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    } else {
                        for (Produto produto : loja.listarProdutos()) {
                            System.out.println("ID: " + produto.getId() + " Nome: " + produto.getNome());
                        }
                    }

                    int opcionador;
                    do {
                        System.out.println("Insira o ID do produto: ");
                        int idProdutoPedido = ler.nextInt();
                        Produto produtoPedido = null;
                        for (Produto produto : loja.listarProdutos()) {
                            if (produto.getId() == idProdutoPedido) {
                                produtoPedido = produto;
                                break;
                            }
                        }
                        if (produtoPedido == null) {
                            System.out.println("Produto não encontrado.");
                            break;
                        }
                        loja.adicionarProduto(produtoPedido);

                        System.out.println("Deseja adicionar mais produtos? (1:Sim/2:Nao)");
                        opcionador = ler.nextInt();
                    } while (opcionador != 2);


                    //finalizar e adicionar o pedido
                    loja.realizarPedido(clientePedido, loja.listarProdutos());
                    break;


                case 6:
                    System.out.println("Remover produto:");

                    System.out.println("Produtos disponiveis: ");
                    if (loja.listarProdutos().isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    } else {
                        for (Produto produto : loja.listarProdutos()) {
                            System.out.println("ID: " + produto.getId() + " Nome: " + produto.getNome());
                        }
                    }


                    int opcionador2;
                    do {
                        System.out.println("Insira o ID do produto: ");
                        loja.removerProduto(loja.buscarProdutoPorId(ler.nextInt()));


                        if (loja.buscarProdutoPorId(ler.nextInt()) == null) {
                            System.out.println("Produto não encontrado.");
                            break;
                        }
                        else {
                            System.out.println("Produto removido com sucesso");
                        }


                        System.out.println("Deseja remover mais produtos? (1:Sim/2:Nao)");
                        opcionador2 = ler.nextInt();
                    } while (opcionador2 != 2);
                    break;



                case 7:
                    System.out.println("Remover cliente");

                    if (loja.listarClientes().isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    } else {
                        for (Cliente cliente : loja.listarClientes()) {
                            System.out.println("Clientes disponiveis: ");
                            System.out.println("Id: " + cliente.getId() + " Nome: " + cliente.getNome());
                        }
                    }


                    int opcionador3;
                    do {
                        System.out.println("Insira o id do cliente que deseja remover: ");
                        loja.removerCliente(loja.buscarClientePorId(ler.nextInt()));
                        if(loja.buscarClientePorId(ler.nextInt()) == null){
                            System.out.println("Cliente não encontrado.");
                            break;
                        }
                        else {
                            System.out.println("Cliente removido com sucesso");
                        }


                        System.out.println("Deseja remover mais produtos? (1:Sim/2:Nao)");
                        opcionador3 = ler.nextInt();
                    }while(opcionador3!=2);

                    break;


               case 8:
                    //mostrar produtos e informações específicas
                   Produto produtoConsulta = null;

                   System.out.println("Produtos disponiveis: ");
                    if (loja.listarProdutos().isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    } else {
                        for (Produto produto : loja.listarProdutos()) {
                            System.out.println("ID: " + produto.getId() + " Nome: " + produto.getNome());
                        }
                    }

                    System.out.println("Insira o ID do protudo que deseja consultar: ");
                    produtoConsulta = loja.buscarProdutoPorId(ler.nextInt());

                    if( produtoConsulta == null){
                        System.out.println("Produto não encontrado");
                    }
                    else{
                        System.out.println("Informacoes sobre o produto: ");
                        System.out.println("ID: " + produtoConsulta.getId() + ", Nome: "+ produtoConsulta.getNome() + ", Preco: " + produtoConsulta.getPreco() + ", Descricao: " + produtoConsulta.getDescricao());
                    }

                case 9:
                    //consultar cliente por id
                    Cliente clienteConsulta = null;

                    System.out.println("Clientes disponiveis: ");
                    if (loja.listarClientes().isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                        break;
                    } else {
                        for (Cliente cliente : loja.listarClientes()) {
                            System.out.println("ID: " + cliente.getId() + " Nome: " + cliente.getNome());
                        }
                    }

                    System.out.println("Insira o ID do cliente que deseja consultar: ");
                    clienteConsulta = loja.buscarClientePorId(ler.nextInt());

                    if(clienteConsulta == null){
                        System.out.println("Cliente não encontrado");
                    }
                    else{
                        System.out.println("Informacoes sobre o cliente: ");
                        System.out.println("ID: " + clienteConsulta.getId() + ", Nome: " + clienteConsulta.getNome() + ", Email: " + clienteConsulta.getEmail() + ", Endereco: " + clienteConsulta.getEndereco());
                    }


            }
        } while (opcao != 0);
    }
}

//projeto em repositorio no github

//adicionados os case 8 e 9 par consulta completa de itens especificos