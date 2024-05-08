/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jontatas.contabanco.gestaoContas;

/**
 *
 * @author jonat
 */


import java.util.ArrayList;
import java.util.List;

public class ListaContas {

    private static List<Conta> contas;

    public ListaContas() {
        this.contas = new ArrayList<>();
    }
    
    public static void adicionarConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso!");
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
        System.out.println("Conta removida com sucesso!");
    }

    public Conta encontrarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null; 
    }

    public Conta encontrarContaPorCPF(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                return conta;
            }
        }
        return null; 
    }

    public List<Conta> getContas() {
        return contas;
    }
}

