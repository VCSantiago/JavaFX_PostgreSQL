/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author vinic
 */
public class ModeloProduto {
   
    private final SimpleStringProperty nome;
    private final SimpleIntegerProperty valor;
    private final SimpleStringProperty Code;

    public ModeloProduto(String nome, Integer idade, String endereco) {
        this.nome = new SimpleStringProperty(nome);
        this.valor = new SimpleIntegerProperty(idade);
        this.Code = new SimpleStringProperty(endereco);
    }
    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public int getIdade() {
        return valor.get();
    }

    public SimpleIntegerProperty idadeProperty() {
        return valor;
    }

    public void setIdade(int idade) {
        this.valor.set(idade);
    }

    public String getEndereco() {
        return Code.get();
    }

    public SimpleStringProperty enderecoProperty() {
        return Code;
    }

    public void setEndereco(String endereco) {
        this.Code.set(endereco);
    }
}
