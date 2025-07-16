package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO TRATAMENTO DE ERROS
        Gerenciador g = new Gerenciador();
        cadastro(g);
        menu(g);
    }
    private static void menu(Gerenciador g) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nO que deseja fazer agora?\n");

            System.out.println(
                "1. Cadastrar nova conta\n" +
                "2. Realizar deposito\n" +
                "3. Realizar saque\n" +
                "4. Realizar transferencia\n" +
                "5. Verificar saldo\n" +
                "6. Finalizar atendimento"
        );
        String valor = sc.nextLine();
        if(!valor.matches("^[0-9.]+$")) {
            throw new BusinnesException("Digite um valor válido!\n");
        }
        var opcao = Integer.parseInt(valor);
        var selecionarOpcao = Menu.values()[(opcao-1)];
        switch (selecionarOpcao) {
            case CADASTRAR -> cadastro(g);
            case DEPOSITO -> {
                System.out.println("Insira sua agência: ");
                long id = sc.nextInt();
                System.out.println("Insira o valor de deposito: ");
                double deposito = sc.nextDouble();
                g.fazerDeposito(id, deposito);
                sc.nextLine();
            }
            case SAQUE -> {
                System.out.println("Insira sua agência: ");
                long id = sc.nextInt();
                System.out.println("Insira o valor de saque: ");
                double saque = sc.nextDouble();
                g.fazerSaque(id, saque);
                sc.nextLine();

            }
            case TRANSFERIR -> {
                System.out.println("Insira sua agência: ");
                long id = sc.nextInt();
                System.out.println("Insira a agência da conta que deseja transferir: ");
                long id2 = sc.nextInt();
                System.out.println("Insira o valor de deposito: ");
                double quantia = sc.nextDouble();
                g.fazerTransferencia(id, id2, quantia);
                sc.nextLine();
            }
            case SALDO -> {
                System.out.println("Insira a agência da conta que deseja verificar: ");
                long id = sc.nextInt();
                System.out.println(g.getContas().get(id));
                sc.nextLine();

            }
            case SAIR -> System.exit(0);
        }}
    }
        private static void cadastro(Gerenciador g) {
        while(true) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Vamos começar com seu cadastro!\n");
            System.out.println("Digite o seu nome e sobrenome: ");
            String nome = sc.nextLine();
            if(!nome.matches("^[a-zA-Z\\s]*$") || nome.split(" ").length < 2) {
                throw(new BusinnesException("\nDigite nome e sobrenome, sem simbolos!\n"));
            }
            System.out.println("Digite quanto deseja depositar: ");
            String saldo = sc.nextLine();
            saldo = saldo.replace(",", ".");
            if(!saldo.matches("^[0-9.]+$")) {
                throw new BusinnesException("Digite um valor válido!");
            }
            System.out.println("Deseja criar uma conta poupança(digite 1) ou corrente?(digite 2)");
            String tipo = sc.nextLine();
            if(!tipo.matches("^[0-9.]+$")) {
                throw new BusinnesException("Digite um valor válido!");
            }
            var opcao = Integer.parseInt(tipo);
            TipoConta tipoConta = TipoConta.values()[opcao-1];
            switch (tipoConta) {
                case POUPANÇA -> {
                    Conta conta = new ContaPoupança(nome,Double.parseDouble(saldo), 0);
                    g.adicionar(conta);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println("Sua agência é: " + conta.getId());
                    return;
                }
                case CORRENTE -> {
                    System.out.println("Qual o limite de crédito desejado?");
                    double limite = sc.nextDouble()*0.6;
                    Conta conta = new ContaCorrente(nome,Double.parseDouble(saldo), limite);
                    g.adicionar(conta);
                    System.out.println("Conta criada com sucesso!\n");
                    System.out.println("Sua agência é: " + conta.getId());
                    return;
                }
            }
        }catch (BusinnesException e) {
            System.out.println(e.getMessage());
        }
    }}
}



