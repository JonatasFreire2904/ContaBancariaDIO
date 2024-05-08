package jontatas.contabanco.Menus;

import java.util.Scanner;
import jontatas.contabanco.gestaoContas.ListaContas;

public class MenuInicial {
        
    public void menuInicial(ListaContas listaContas){   
        
        int opcao;
        Scanner in = new Scanner(System.in);
        
        do {
            System.out.println("### MENU Inicial ###");
            System.out.println("1. Gerência");
            System.out.println("2. Cliente");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = in.nextInt();
            in.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    GerenteOpcoes.menuGerente(listaContas); // Passando lista de contas como argumento
                    break;
                case 2:
                    ClienteOpcoes.menuCliente(listaContas); // Passando lista de contas como argumento
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }
}
