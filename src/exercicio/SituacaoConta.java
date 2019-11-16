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
public enum SituacaoConta {

    ABERTA(0), FECHADA(1), SEM_MOVIMENTACAO(2);

    private final int valorSituacao;

    SituacaoConta(int valor) {
        this.valorSituacao = valor;

    }

    public int getValorSituacao() {
        return valorSituacao;
    }
    
    
    

}
