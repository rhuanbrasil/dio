package org.example;

import java.util.Objects;

public class ContaCorrente extends Conta {


    public ContaCorrente(String nome, double saldo, double credito) {
        super(nome, saldo, credito);
    }

    @Override
    public double calcularTaxaSaque(double valor) {
        return valor * 0.08;
    }

    @Override
    public double calcularTaxaDeposito(double valor) {
        return valor * 0.05;
    }

    @Override
    public double calcularTaxaTransferencia(double valor) {
        return valor * 0.03;
    }
}
