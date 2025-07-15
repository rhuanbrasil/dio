package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArmazenamentoContas contas = new ArmazenamentoContas();
        contas.novaContaCorrente(123, "Rhuan", 1500d, 1000d);
        contas.novaContaCorrente(1234, "Lidia", 1500d, 1000d);
        System.out.println("Antes da mudança");
        contas.getContas().forEach(System.out::println);
        System.out.println("Depois da mudança");
        contas.Saque("Rhuan", "Lidia", 1500d);;
        contas.getContas().forEach(System.out::println);

    }
}



