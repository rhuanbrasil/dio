package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gerenciador g = new Gerenciador();
        cadastro(g);
        menu(g);
    }
    private static void menu(Gerenciador g) {
        Scanner sc = new Scanner(System.in);

         while (true) {
            try {
                System.out.println("\nO que deseja fazer agora?\n");

                System.out.println(
                        "1. Cadastrar nova conta\n" +
                                "2. Realizar deposito\n" +
                                "3. Realizar saque\n" +
                                "4. Realizar transferencia\n" +
                                "5. Verificar saldo\n" +
                                "6. Finalizar atendimento"
                );
                String valor = sc.next();
                if (!valor.matches("^[0-6.]+$")) {
                    throw new BusinnesException("Digite um valor válido!\n");
                }
                var opcao = Integer.parseInt(valor);
                var selecionarOpcao = Menu.values()[(opcao - 1)];
                switch (selecionarOpcao) {
                    case CADASTRAR -> cadastro(g);
                    case DEPOSITO -> {
                        System.out.println("Insira sua agência: ");
                        String id = sc.next();
                        if (!id.matches("^[0-9.]+$")) {
                            throw new BusinnesException("Digite um valor válido!\n");
                        }
                        var idF = Long.parseLong(id);
                        System.out.println("Insira o valor de deposito: ");
                        String saldo = sc.next();
                        saldo = saldo.replace(",", ".");
                        if (!saldo.matches("^[0-9.]+$")) {
                            throw new BusinnesException("Digite um valor válido!");
                        }
                        var saldoF = Double.parseDouble(saldo);
                        g.fazerDeposito(idF, saldoF);
                        sc.nextLine();
                    }
                    case SAQUE -> {
                        System.out.println("Insira sua agência: ");
                        String id = sc.next();
                        if (!id.matches("^[0-9.]+$")) {
                            throw new BusinnesException("Digite um valor válido!\n");
                        }
                        var idF = Long.parseLong(id);
                        System.out.println("Insira o valor de saque: ");
                        String saldo = sc.next();
                        saldo = saldo.replace(",", ".");
                        if (!saldo.matches("^[0-9.]+$")) {
                            throw new BusinnesException("Digite um valor válido!");
                        }
                        var saldoF = Double.parseDouble(saldo);
                        g.fazerSaque(idF, saldoF);
                        sc.nextLine();

                    }
                    case TRANSFERIR -> {
                        System.out.println("Insira sua agência: ");
                        String id = sc.next();
                        if (!id.matches("^[0-9.]+$")) {
                            throw new BusinnesException("Digite um valor válido!\n");
                        }
                        var idF = Long.parseLong(id);
                        System.out.println("Insira a agência da conta que deseja transferir: ");
                        String id2 = sc.next();
                        if (!id2.matches("^[0-9.]+$")) {
                            throw new BusinnesException("Digite um valor válido!\n");
                        }
                        var idF2 = Long.parseLong(id);
                        System.out.println("Insira o valor de deposito: ");
                        String saldo = sc.next();
                        saldo = saldo.replace(",", ".");
                        if (!saldo.matches("^[0-9.]+$")) {
                            throw new BusinnesException("Digite um valor válido!");
                        }
                        var saldoF = Double.parseDouble(saldo);
                        g.fazerTransferencia(idF, idF2, saldoF);
                        sc.nextLine();
                    }
                    case SALDO -> {
                        System.out.println("Insira a agência da conta que deseja verificar: ");
                        String id = sc.next();
                        if (!id.matches("^[0-9.]+$")) {
                            throw new BusinnesException("Digite um valor válido!\n");
                        }
                        var idF = Long.parseLong(id);
                        System.out.println(g.getContas().get(idF));
                        sc.nextLine();

                    }
                    case SAIR -> System.exit(0);
                }
            }catch (BusinnesException e){
                System.out.println(e.getMessage());
            }
            }

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



