/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

/**
 *
 * @author Evandro
 */
public class ContaEspecial extends Conta {

    private final double limit;

    public ContaEspecial(double limit, Double saldo, int numero, String agencia) {
        super(saldo, numero, agencia);
        this.limit = limit;
        
    }

    public double getLimit() {
        return limit;
    }

    @Override
    public void credita(double saldo) {
        
        
        setSaldo(getSaldo() + saldo);

    }

    @Override
    public void debita(double saldo) {
        
           
        double saque = getSaldo();
        if (saldo < (saque + limit) || saldo == (saque + limit)) {

            setSaldo(saque - saldo);

        }
   

    }

    @Override
    public String toString() {
        return "ContaEspecial{" + "limit=" + limit + super.toString();
    }
    
    
    
    

}
