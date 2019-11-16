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
public class ContaCorrente extends Conta {

    public ContaCorrente(Double saldo, int numero, String agencia) {
        super(saldo, numero, agencia);
    }
    
    
    

    @Override
    public void credita(double saldo) {

        setSaldo(getSaldo() + saldo);

    }

    @Override
    public void debita(double saldo) {

        double saque = getSaldo();

        if (saque > saldo || saque == saldo) {

            super.setSaldo(saque-saldo);

        } else {

            JOptionPane.showMessageDialog(null, "Não há saldo suficiente!");

        }

    }
    
  

    @Override
    public String toString() {
        return "ContaCorrente{" + ")" + super.toString();
    }
    
    

}
