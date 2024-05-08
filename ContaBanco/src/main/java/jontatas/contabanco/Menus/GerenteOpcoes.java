package jontatas.contabanco.Menus;

import java.util.Scanner;
import jontatas.contabanco.gestaoContas.Conta;
import jontatas.contabanco.gestaoContas.ListaContas;

public class GerenteOpcoes {
    
    private static Scanner in = new Scanner(System.in);

    public static void menuGerente(ListaContas listaContas) {
        int opcao;
        
        do {
            System.out.println("### MENU GERENTE ###");
            System.out.println("1. Cadastrar nova Conta");
            System.out.println("2. Alterar cadastro");
            System.out.println("3. Deletar conta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = in.nextInt();
            in.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    cadastrarNovaConta(listaContas);
                    break;
                case 2:
                    alterarCadastro(listaContas);
                    break;
                case 3:
                    deletarConta(listaContas);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private static void cadastrarNovaConta(ListaContas listaContas) {
        Double saldoInicial = 0.0;
        
        System.out.print("Digite o numero da Agencia: ");
        String agencia = in.nextLine();
        
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = in.nextLine();
        
        System.out.print("CPF do cliente: ");
        String cpf = in.nextLine();
        
        System.out.print("Deseja realizar depósito inicial ? (s/n): ");
        String opcao = in.nextLine();
        if(opcao.equalsIgnoreCase("s")){
           System.out.print("Digite o valor desejado: ");     
           saldoInicial = in.nextDouble();
           in.nextLine(); // Limpar o buffer do scanner
        }
        
        Conta conta = new Conta(agencia, nomeCliente, cpf, saldoInicial);
        listaContas.adicionarConta(conta); // Adiciona a conta à lista de contas
        System.out.println("Cadastrando nova conta...");      
        
    }

    private static void alterarCadastro(ListaContas listaContas) {
        System.out.print("Digite o CPF do cliente que deseja alterar o cadastro: ");
        String cpf = in.nextLine();

        Conta conta = listaContas.encontrarContaPorCPF(cpf);
        if (conta != null) {
            System.out.println("Cadastro encontrado:");
            System.out.println(conta);

            System.out.println("Qual dado deseja alterar ?");
            System.out.println("1. Agência");
            System.out.println("2. Nome");
            int opcao = in.nextInt();
            in.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite a nova agência: ");
                    String novaAgencia = in.nextLine();
                    conta.setAgencia(novaAgencia);
                    System.out.println("Agência alterada com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o novo nome: ");
                    String novoNome = in.nextLine();
                    conta.setNome(novoNome);
                    System.out.println("Nome alterado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void deletarConta(ListaContas listaContas) {
        System.out.print("Digite o CPF do cliente que deseja deletar a conta: ");
        String cpf = in.nextLine();

        Conta conta = listaContas.encontrarContaPorCPF(cpf);
        if (conta != null) {
            listaContas.removerConta(conta);
            System.out.println("Conta deletada com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
