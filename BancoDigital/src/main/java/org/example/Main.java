package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO MENU INTERAGIVEL
        try {
            ArmazenamentoContas contas = new ArmazenamentoContas();
            Conta conta = new ContaCorrente("rhuan", 1500d, 1000d);
            Conta conta2 = new ContaCorrente("julia", 1500d, 1000d);
            Conta conta3 = new ContaPoupança("jonas", 1500d, 0);

            contas.adicionar(conta);
            contas.adicionar(conta2);
            contas.adicionar(conta3);
            System.out.println("Antes da transferencia: \n" + contas.getContas());
            contas.fazerTransferencia(conta.getId(), conta2.getId(), 1000);
            System.out.println("Depois da transferencia: \n" + contas.getContas());
            contas.fazerSaque(conta2.getId(), 1500);
            contas.fazerSaque(conta3.getId(), 1400);
            System.out.println("Depois do saque: \n" + contas.getContas());
        }catch (BusinnesException e) {
            System.out.println(e.getMessage());
        }
    }
}



