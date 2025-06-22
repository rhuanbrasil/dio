package program;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
                Scanner terminal = new Scanner(System.in);
                System.out.println("Digite o primeiro parâmetro");
                int parametroUm = terminal.nextInt();
                System.out.println("Digite o segundo parâmetro");
                int parametroDois = terminal.nextInt();

                try {
                   for (var i = 0; i < contar(parametroUm, parametroDois); i++) {
                       System.out.println("Imprimindo o número " + (i+1));
                   }

                }catch (ParametrosInvalidosException exception) {
                    System.out.println(exception.getMessage());
                }

            }
            static int contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
                if (parametroUm > parametroDois) {
                    throw new ParametrosInvalidosException("Informe um primeiro valor menor que o primeiro");
                }
               return parametroDois - parametroUm;
            }
}

