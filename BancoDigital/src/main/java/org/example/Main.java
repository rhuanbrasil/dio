package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO MENU INTERAGIVEL
        Scanner sc = new Scanner(System.in);
        Gerenciador g = new Gerenciador();
        try {
            System.out.println("Vamos começar com seu cadastro!");
            System.out.println("Digite o seu nome e sobrenome: ");
            String nome = sc.nextLine();
            if(!nome.matches("^[a-zA-Z\\s]*$") || nome.split(" ").length < 2) {
                throw(new BusinnesException("Digite nome e sobrenome, sem simbolos!"));
            }
            System.out.println("Digite quanto deseja depositar: ");
            String saldo = sc.nextLine();
            saldo = saldo.replace(",", ".");
            if(!saldo.matches("^[0-9.]+$")) {
                throw new BusinnesException("Digite um valor válido!");
            }
            System.out.println("Deseja criar uma conta poupança(digite 1) ou corrente?(digite 2)");
            int tipo = sc.nextInt();
            TipoConta tipoConta = TipoConta.values()[tipo-1];
            switch (tipoConta) {
                case POUPANÇA -> {
                    Conta conta = new ContaPoupança(nome,Double.parseDouble(saldo), 0);
                    g.adicionar(conta);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println("Sua agência é: " + conta.getId());

                }
                case CORRENTE -> {
                    System.out.println("Qual o limite de crédito desejado?");
                    double limite = sc.nextDouble()*0.6;
                    Conta conta = new ContaCorrente(nome,Double.parseDouble(saldo), limite);
                    g.adicionar(conta);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println("Sua agência é: " + conta.getId());

                }
            }
            System.out.println(g.getContas());
        }catch (BusinnesException e) {
            System.out.println(e.getMessage());
        }
    }
}



