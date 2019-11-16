/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

import javax.swing.JOptionPane;

/**
 *
 * @author Evandro
 */
public abstract class Conta implements OperacoesConta {

    private Double saldo;
    private int numero;
    private String agencia;
    private SituacaoConta sconta;

    public Conta(Double saldo, int numero, String agencia) {

        this.saldo = saldo;
        this.numero = numero;
        this.agencia = agencia;
        
        
       
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public SituacaoConta getSconta() {
        return sconta;
    }

    public void setSconta() {
        int situacao = Integer.parseInt(JOptionPane.showInputDialog("Informe a situacao da Conta\n 0 - Aberta\n"
                + "1 – Fechada\n" + "2 - Sem Movimentação\n"));

      

        switch (situacao) {
            case 0:
                this.sconta = SituacaoConta.ABERTA;
                break;
            case 1:
                this.sconta = SituacaoConta.FECHADA;
                break;
            case 2:
                this.sconta = SituacaoConta.SEM_MOVIMENTACAO;
                break;
            default:
                JOptionPane.showMessageDialog(null, "opção inválida");
                setSconta();
                break;
        }
    
    }
    
    

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

   
    public void credita(double saldo) {


    }

   
    public void debita(double saldo) {

    }
    
    
    
    
    
    

    @Override
    public String toString() {
        return "Conta{" + "saldo=" + saldo + ", numero=" + numero + ", agencia=" + agencia + '}';
    }

}
