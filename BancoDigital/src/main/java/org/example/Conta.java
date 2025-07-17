package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class Conta {
    private final long id;
    private String nome;
    private double saldo;
    private double credito;
    private List<Double> extrato;

    public List<Double> getExtrato() {
        return extrato;
    }

    public abstract double calcularTaxaSaque(double valor);
    public abstract double calcularTaxaDeposito(double valor);
    public abstract double calcularTaxaTransferencia(double valor);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return id == that.getId();
    }
    public boolean saque(double valor){
        double taxa =  calcularTaxaSaque(valor);
        double total = valor + taxa;
        if (saldo >= total){
            saldo -= total;
            return true;
        }
        throw(new BusinnesException("Não foi possível realizar a operação de saque. (verifique se tem saldo suficiente)"));
    }
    public boolean deposito(double valor){
        double taxa =  calcularTaxaDeposito(valor);
        double total = valor + taxa;
        if (saldo >= total){
            saldo += valor - taxa;
            return true;
        }
        throw(new BusinnesException("Não foi possível realizar a operação de deposito. (verifique se tem saldo suficiente)"));
    }
    public boolean transferencia(Conta destino, double valor){
        double taxa =  calcularTaxaTransferencia(valor);
        double total = valor + taxa;
        if (saldo >= total){
            saldo -= total;
            destino.deposito(valor);
            return true;
        }
        throw(new BusinnesException("Não foi possível realizar a operação de transferencia. (verifique se tem saldo suficiente)"));
    }
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String toString() {
        return String.format(" Conta:\n" +
                "  %-10s: %s\n" +
                "  %-10s: %.2f\n" +
                "  %-10s: %.2f \n",
                "Nome", nome,
                "Saldo", saldo,
                "Crédito", credito
        );
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Conta(String nome, double saldo, double credito) {
        this.id = Math.abs(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE % 100000);
        this.nome = nome;
        this.saldo = saldo;
        this.credito = credito;
        this.extrato = new ArrayList<>();
    }

}
