package org.example;

import java.util.HashSet;
import java.util.Set;

public class ArmazenamentoContas {
    private Set<Conta> contas;

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    public ArmazenamentoContas() {
        contas = new HashSet<>();
    }

    public void novaContaCorrente(long id, String nome, double saldo, double credito) {
        contas.add(new ContaCorrente(id, nome, saldo, credito));
    }
    public Conta findByName(String name) {
        return contas.stream().filter(c -> c.getNome().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    public void Saque(String nome, String nome2, double valor) {
        findByName(nome).setSaldo(findByName(nome).getSaldo() - valor);
        findByName(nome2).setSaldo(findByName(nome2).getSaldo() + valor);
    }
}
