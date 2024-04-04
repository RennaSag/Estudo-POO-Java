package com.mycompany.projetoloja;

import java.util.ArrayList;
import java.util.List;


public class Pedido {
    
    private int id;
    private Cliente cliente;
    private List<Produto> produtos;
    private String status;
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    
    
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    
    public List<Produto> getProdutos(){
        return produtos;
    }
    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }

    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
}
