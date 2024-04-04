package com.mycompany.projetoloja;

import java.util.ArrayList;
import java.util.List;

public class LojaOnline {
    
    private String nome;
    private List<Produto> listaProdutos;
    private List<Cliente> listaClientes;
    private List<Pedido> listaPedidos;
    
    
    //iniciar as listas vazias 
    public LojaOnline(){
        listaProdutos = new ArrayList<>();
        listaClientes = new ArrayList<>(0);
    }
    
    

    public void adicionarProduto(Produto produto){
        listaProdutos.add(produto);
    }
    public void removerProduto(Produto produto){
        listaProdutos.remove(produto);
    }
    

    public void adicionarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public void removerCliente(Cliente cliente){
        listaClientes.remove(cliente);
    }
    
    

    public Produto buscarProduto(String nome){
        for(Produto produto : listaProdutos){
            if(produto.getNome().equals(nome)){
                return produto;
            }
        }return null;
    }
    
    
    

    public List<Produto> listarProdutos(){
        return listaProdutos;
    }
    public List<Cliente> listarClientes(){
        return listaClientes;
    }
    
    

    public Cliente buscarClientePorEmail(String email){
        for(Cliente cliente : listaClientes){
            if(cliente.getEmail().equals(email)){
                return cliente;
            }
        }return null;
    }
    
    

    public Pedido realizarPedido(Cliente cliente, List<Produto> produtos) {
        Pedido pedido = new Pedido();
        listaPedidos.add(pedido);
        return pedido;
    }
    
    
}
