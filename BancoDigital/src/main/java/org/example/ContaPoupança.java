package org.example;

public class ContaPoupança extends Conta {
    @Override
    public double calcularTaxaSaque(double valor) {
        return valor * 0.10;
    }

    @Override
    public double calcularTaxaDeposito(double valor) {
        return valor * 0.03;
    }

    @Override
    public double calcularTaxaTransferencia(double valor) {
        return valor * 0.01;
    }


    public ContaPoupança(String nome, double saldo, double credito) {
        super(nome, saldo, credito);
    }
}
