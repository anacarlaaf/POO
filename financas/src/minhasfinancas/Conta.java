package minhasfinancas;
import java.util.*;

abstract class Conta<T>{
    protected int codigo;
    protected String nome;
    protected int numeroConta;
    protected double saldo;
    protected String tokenAcesso;
    protected List<T> transacoes;

    public Conta(){};

    public Conta(int codigo, String nome, int numeroConta) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.transacoes = new ArrayList<>();
    }

    public String getNome() {
      return this.nome;
    }

    public int getCodigo() {
      return this.codigo;
    }

    public double getSaldo() {
      return this.saldo;
    }

    public void addTransacao(T transacao){
        this.transacoes.add(transacao);
    }

    public abstract void sincronizar();
}