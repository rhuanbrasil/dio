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

    public boolean fazerSaque(long id, double saque) {
        Conta conta = contas.get(id);
        if (conta != null) {
            return conta.saque(saque);
        }
        return false;
    }
    public boolean fazerTransferencia(long origem_,long destino_, double saque) {
        Conta origem = contas.get(origem_);
        Conta destino = contas.get(destino_);
        if (origem != null && destino != null) {
            return origem.transferencia(destino, saque);
        }
        return false;
    }
}
