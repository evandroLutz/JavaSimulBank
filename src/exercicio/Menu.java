/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Evandro
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList();

        // TODO code application logic here
        while (true) {

            int opcao = Integer.parseInt(JOptionPane.showInputDialog(MenuConta()));
            switch (opcao) {
                case 1: //Cadastrar Cliente
                    ArrayList<Conta> contas = new ArrayList();
                    String nome = JOptionPane.showInputDialog("Informe o nome do cliente:");
                    String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente");

                    boolean cadastra = true;

                    //Declarando a lista de Contas
                    while (cadastra) {

                        Double saldo = Double.parseDouble(JOptionPane.showInputDialog("Informe o saldo da Conta"));
                        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta\n"));
                        String agencia = JOptionPane.showInputDialog("Digite o número da agencia");

                        int tipo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tipo da Conta\n 1 - Cadastrar Conta Corrente\n"
                                + "2 – Cadastrar Conta Especial\n"));

                        //adicionando Conta na lista
                        if (tipo == 1) {

                            Conta cc = new ContaCorrente(saldo, numero, agencia);

                            cc.setSconta();
                            contas.add(cc);
                            JOptionPane.showMessageDialog(null, "Conta Cadastrada");

                        } else if (tipo == 2) {

                            Double limite = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite"));
                            Conta ce = new ContaEspecial(limite, saldo, numero, agencia);
                            ce.setSconta();
                            contas.add(ce);
                            JOptionPane.showMessageDialog(null, "Conta Cadastrada");

                        }

                        int continuar = Integer.parseInt(JOptionPane.showInputDialog("Deseja Cadastrar outra Conta para este cliente?\n 1 - Sim\n"
                                + "2 – Não(sair)\n"));

                        switch (continuar) {
                            case 1:
                                break;
                            case 2:
                                cadastra = false;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida");
                                System.exit(0);
                                break;
                        }
                    }

                    //criando objeto Cliente e inserindo as contas
                    clientes.add(new Cliente(nome, cpf, contas));

                    break;

                case 2://Depositar usando o código da Conta e Agência
                    if (!clientes.isEmpty()) {
                        int codigoDep = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da Conta"));

                        String agenciaDep = JOptionPane.showInputDialog("Digite a agência da Conta");

                        for (Cliente cliente : clientes) {

                            for (Conta conta : cliente.getContas()) {

                                if (conta.getAgencia().equals(agenciaDep) && (conta.getNumero() == codigoDep)) {

                                    if (conta.getSconta().equals(SituacaoConta.ABERTA)) {

                                        JOptionPane.showMessageDialog(null, "Saldo disponível: " + conta.getSaldo());

                                        double credito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser creditado"));

                                        conta.credita(credito);

                                        JOptionPane.showMessageDialog(null, "Saldo disponível: " + conta.getSaldo());
                                    } else {

                                        JOptionPane.showMessageDialog(null, "A conta não está aberta");

                                    }

                                }

                            }

                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "Não há clientes e contas disponíveis");

                    }
                    break;
                case 3://Sacar usando número da conta e agência
                    if (!clientes.isEmpty()) {
                        int codigoCre = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da Conta"));

                        String agenciaCre = JOptionPane.showInputDialog("Digite a agência da Conta");

                        for (Cliente cliente : clientes) {

                            for (Conta conta : cliente.getContas()) {
                                if (conta.getAgencia().equals(agenciaCre) && (conta.getNumero() == codigoCre)) {

                                    if (conta.getSconta().equals(SituacaoConta.ABERTA)) {

                                        JOptionPane.showMessageDialog(null, "Saldo disponível: " + conta.getSaldo());

                                        double saque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser sacado"));

                                        conta.debita(saque);

                                        JOptionPane.showMessageDialog(null, "Saldo disponível: " + conta.getSaldo());

                                    } else {

                                        JOptionPane.showMessageDialog(null, "A conta não está aberta");

                                    }

                                }

                            }
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Não há clientes e contas disponíveis");

                    }
                    break;
                case 4:// Listar todos os Clientes e suas respectivas contas
                    if (!clientes.isEmpty()) {
                        for (Cliente cliente : clientes) {

                            JOptionPane.showMessageDialog(null, "Número de Clientes: " + cliente.getContador() + " Nome: " + cliente.getNome() + "  " + cliente.getContas());

                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Não há clientes e contas disponíveis");

                    }
                    break;
                case 5: // Listar todas as contas Abertas
                    if (!clientes.isEmpty()) {
                        for (Cliente cliente : clientes) {

                            for (Conta conta : cliente.getContas()) {
                                if (conta.getSconta().equals(SituacaoConta.ABERTA)) {

                                    JOptionPane.showMessageDialog(null, "Conta: " + conta.getNumero());

                                }

                            }
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Não há contas disponíveis");

                    }
                    break;
                case 6:// Listar todas as contas Fechadas
                    if (!clientes.isEmpty()) {
                        for (Cliente cliente : clientes) {

                            for (Conta conta : cliente.getContas()) {
                                if (conta.getSconta().equals(SituacaoConta.FECHADA)) {

                                    JOptionPane.showMessageDialog(null, "Conta: " + conta.getNumero());

                                }

                            }

                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Não há contas disponíveis");

                    }
                    break;
                case 7: // Listar todas as contas Sem movimentação
                    if (!clientes.isEmpty()) {
                        for (Cliente cliente : clientes) {

                            for (Conta conta : cliente.getContas()) {
                                if (conta.getSconta().equals(SituacaoConta.SEM_MOVIMENTACAO)) {

                                    JOptionPane.showMessageDialog(null, "Conta: " + conta.getNumero());

                                }

                            }
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Não há contas disponíveis");

                    }
                    break;
                case 8: // Sair
                    System.exit(0);
            }
        }

    }

    public static String MenuConta() {
        return "1 - Cadastrar Cliente e suas Contas\n"
                + "2 – Depositar\n"
                + "3 – Sacar\n"
                + "4 – Listar Clientes e Contas\n"
                + "5 – Listar Contas abertas\n"
                + "6- Listas Contas fechadas\n"
                + "7-Listas Contas sem movimentação\n"
                + "8-Sair";

    }

}
