package Program;

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        int numero;
        String agencia;
        String nome;
        double saldo;

        Scanner input = new Scanner(System.in);


        System.out.println("Seja bem vindo ao banco TAL! Favor preencha as seguintes informações:");
        System.out.print("Seu nome: ");
        nome = input.nextLine();
        System.out.print("Sua agencia: ");
        agencia = input.nextLine();
        System.out.print("Numero da conta: ");
        numero = input.nextInt();
        System.out.print("Saldo da conta: ");
        saldo = input.nextDouble();

        System.out.printf(
                "Olá %s, obrigado por criar uma conta em nosso banco," +
                " sua agência é %s, conta %d e seu saldo %.2f" +
                " já está disponível para saque", nome, agencia, numero, saldo
        );






    }
}
