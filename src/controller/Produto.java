/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


public class Produto {
    private String nome;
    private int qtd;
    private float valorCompra;
    private float valorVenda;
    private int codigo;
    
    
    public int getCodigo() {
        return codigo;
    }

    public Produto(String nome, int qtd, float valorCompra, float valorVenda, int codigo) {
        this.nome = nome;
        this.qtd = qtd;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the valorCompra
     */
    public float getValorCompra() {
        return valorCompra;
    }

    /**
     * @param valorCompra the valorCompra to set
     */
    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * @return the valorVenda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

  
}
