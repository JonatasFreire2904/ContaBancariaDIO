package jontatas.contabanco.Menus;

import java.util.Scanner;
import jontatas.contabanco.gestaoContas.Conta;
import jontatas.contabanco.gestaoContas.ListaContas;

public class ClienteOpcoes {
    
    private static Scanner in = new Scanner(System.in);

    public static void menuCliente(ListaContas listaContas) {
        int opcao;
        
        do {
            System.out.println("### MENU CLIENTE ###");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Histórico da conta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = in.nextInt();
            in.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    depositar(listaContas);
                    break;
                case 2:
                    sacar(listaContas);
                    break;
                case 3:
                    exibirHistorico(listaContas);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private static void depositar(ListaContas listaContas) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = in.nextLine();

        Conta conta = listaContas.encontrarContaPorCPF(cpf);
        if (conta != null) {
            System.out.print("Digite o valor a ser depositado: ");
            Double valor = in.nextDouble();
            in.nextLine(); // Limpar o buffer do scanner

            conta.depositar(valor);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void sacar(ListaContas listaContas) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = in.nextLine();

        Conta conta = listaContas.encontrarContaPorCPF(cpf);
        if (conta != null) {
            System.out.print("Digite o valor a ser sacado: ");
            Double valor = in.nextDouble();
            in.nextLine(); // Limpar o buffer do scanner

            conta.sacar(valor);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void exibirHistorico(ListaContas listaContas) {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = in.nextLine();

        Conta conta = listaContas.encontrarContaPorCPF(cpf);
        if (conta != null) {
            conta.exibirHistorico();
        } else {
            System.out.println("Cliente não encontrado.");
        }
        
        System.out.println("Seu saldo atual e de: " + conta.getSaldo());
    }
}
