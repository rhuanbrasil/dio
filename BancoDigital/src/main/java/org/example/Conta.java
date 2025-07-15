package org.example;

import java.util.Objects;

public abstract class Conta {
    private final long id;
    private String nome;
    private double saldo;
    private double credito;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrente that = (ContaCorrente) o;
        return id == that.getId();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String toString() {
        return "ContaCorrente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", credito=" + credito +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Conta(long id, String nome, double saldo, double credito) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.credito = credito;

    }
}
