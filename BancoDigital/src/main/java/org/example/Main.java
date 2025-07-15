package org.example;

import java.util.Scanner;
/*TODO
   ATUALIZAR "CONTA" COM METODOS DE TAXAS E SAQUE DEPOSITO E TRANSFERENCIA; V
    TRANFERENCIA SEM TER COMO ESCOLHER O NOME DO USUARIO;
    UTILIZAR MAP EM VEZ DE SET(ID COMO CHAVE fácil de localizar nos metodos);
    FAZER UM BOOLEAN QUE RETORNE ("TRANSAÇÃO DEU CERTO OU ERRADO") AO FINALIZAR AS FUNÇÕES BOOLEAN;
    METODOS BOOLEAN (RECEBENDO VALOR E (CONTA USUARIO FINAL EM TRANSFERENCIA)) PARA OS TIPOS DE CONTA JÁ FAZENDO OPERAÇÃO;
    METODOS BOOLEAN (RECEBENDO VALOR E ID-ORIGEM E ID-DESTINO PARA TRANSFERENCIA) QUE VERIFICAM SE A CONTA NÃO É NULL E EM SEGUIDA REALIZAOPERAÇÃO;
 */

public class Main {
    public static void main(String[] args) {
        ArmazenamentoContas contas = new ArmazenamentoContas();
        Conta conta = new ContaCorrente("rhuan", 1500d, 1000d);
        Conta conta2 = new ContaCorrente("julia", 1500d, 1000d);
        contas.adicionar(conta);
        contas.adicionar(conta2);
        System.out.println("Antes da transferencia: \n" + contas.getContas());
        contas.fazerTransferencia(conta.getId(), conta2.getId(), 1000);
        System.out.println("Depois da transferencia: \n" + contas.getContas());
        contas.fazerSaque(conta2.getId(), 1500);
        System.out.println("Depois do saque: \n" + contas.getContas());
    }
}



