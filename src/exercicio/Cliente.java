/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

import java.util.ArrayList;

/**
 *
 * @author Evandro
 */
public class Cliente {

    private String nome;
    private String cpf;
    private static int contador;
    private ArrayList<Conta> contas;

    public Cliente(String nome, String cpf, ArrayList<Conta> contas) {
        this.nome = nome;
        this.cpf = cpf;
        this.contas = contas;
        contador++;

    }

    public ArrayList<Conta> getContas() {

        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public int getContador() {

        return contador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", contas=" + contas + '}';
    }

}
