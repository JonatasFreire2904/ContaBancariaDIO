package jontatas.contabanco.gestaoContas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Conta {

    private static final AtomicInteger contadorContas = new AtomicInteger(1); // Inicializa o contador de contas

    private int numeroConta;
    private String agencia;
    private String nome;
    private String cpf;
    private Double saldo;
    private List<String> historico; // Histórico de transações

    public Conta(String agencia, String nome, String cpf, Double saldo) {
        this.numeroConta = contadorContas.getAndIncrement(); // Obtém e incrementa o contador para atribuir o número da conta
        this.agencia = agencia;
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
        this.historico = new ArrayList<>();
    }
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    // Métodos de operação da conta

    public void depositar(Double deposito) {
        this.saldo += deposito;
        historico.add("Depósito de R$" + deposito);
        System.out.println("Depósito realizado com sucesso. Seu novo saldo é de: R$" + getSaldo());
    }

    public void sacar(Double saque) {
        if (saldo >= saque) {
            this.saldo -= saque;
            historico.add("Saque de R$" + saque);
            System.out.println("Saque realizado com sucesso. Seu novo saldo é de: R$" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente. Seu saldo atual é de: R$" + getSaldo());
        }
    }

    public void transferir(Double valor, Conta destino) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            historico.add("Transferência de R$" + valor + " para conta " + destino.getNumeroConta());
            System.out.println("Transferência realizada com sucesso. Seu novo saldo é de: R$" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente para transferência. Seu saldo atual é de: R$" + getSaldo());
        }
    }

    public void exibirHistorico() {
        System.out.println("Histórico de transações da conta " + numeroConta + ":");
        for (String transacao : historico) {
            System.out.println(transacao);
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", agencia='" + agencia + '\'' +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", saldo=" + saldo +
                '}';
    }
    
    public void agradecimento(){
        System.out.println("Olá, " + this.nome +", obrigado por criar uma conta em nosso banco, sua agência é " +
                this.agencia + ", conta " + this.numeroConta +" e seu saldo "+
                this.saldo+" já está disponível para saque.");
    }
}
