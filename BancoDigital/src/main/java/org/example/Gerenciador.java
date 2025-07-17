package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gerenciador {
    private Map<Long, Conta> contas;


    public Map<Long, Conta> getContas() {
        return contas;
    }

    public Gerenciador() {
        contas = new HashMap<>();
    }

    public void adicionar(Conta conta) {
        contas.put(conta.getId(), conta);
    }

    public boolean fazerDeposito(long id, double valor) {
        if (contas.get(id) != null){

            contas.get(id).getExtrato().add((valor - contas.get(id).calcularTaxaDeposito(valor)));
           return contas.get(id).deposito(valor);
        }
        return false;
    }
    public boolean fazerSaque(long id, double valor) {
        if (contas.get(id) != null){
            contas.get(id).getExtrato().add(-(valor + contas.get(id).calcularTaxaSaque(valor)));
            return contas.get(id).saque(valor);
        }
        return false;
    }
    public boolean fazerTransferencia(long id, long contaId, double valor) {
        Conta inicial = contas.get(id);
        Conta destino = contas.get(contaId);
        if (inicial != null && destino != null) {
            inicial.getExtrato().add(-(valor + inicial.calcularTaxaTransferencia(valor)));
            destino.getExtrato().add((valor - destino.calcularTaxaDeposito(valor)));
            return inicial.transferencia(destino, valor);
        }
        return false;
    }
}
