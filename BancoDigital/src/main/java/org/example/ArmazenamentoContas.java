package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArmazenamentoContas {
    private Map<Long, Conta> contas;


    public Map<Long, Conta> getContas() {
        return contas;
    }

    public ArmazenamentoContas() {
        contas = new HashMap<>();
    }

    public void adicionar(Conta conta) {
        contas.put(conta.getId(), conta);
    }

    public boolean fazerDeposito(long id, double valor) {
        if (contas.get(id) != null){
           return contas.get(id).deposito(valor);
        }
        return false;
    }
    public boolean fazerSaque(long id, double valor) {
        if (contas.get(id) != null){
            return contas.get(id).saque(valor);
        }
        return false;
    }
    public boolean fazerTransferencia(long id, long contaId, double valor) {
        Conta inicial = contas.get(id);
        Conta destino = contas.get(contaId);
        if (inicial != null && destino != null) {
           return inicial.transferencia(destino, valor);
        }
        return false;
    }
}
