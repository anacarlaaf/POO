package minhasfinancas;
import java.time.LocalDate;
import java.io.*;
import java.nio.file.*;
import java.util.*;

abstract class Conta{
    protected int codigo;
    protected String nome;
    protected int numeroConta;
    protected double saldo;
    protected String tokenAcesso;
    protected List<T> transacoes;

    public Conta(int codigo, String nome, int numeroConta, string tokenAcesso) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.tokenAcesso = tokenAcesso;
        this.transacoes = new List<>();
    }

    public String getNome() {
      return this.nome;
    }

    public String getSaldo() {
      return this.saldo;
    }

    public abstract void adicionarTransacao(T transacao){
        this.transacoes.add(transacao);
    }

    // public abstract void sincronizar(){} // Em andamento...
}

class Transacao {
    protected int id;
    protected float valor;
    protected LocalDate data;
    protected String descricao;
    protected boolean tipo;
    protected String origem;

    public Transacao(int id, float valor, LocalDate data, String descricao, boolean tipo, String origem) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.tipo = tipo;
        this.origem = origem;
    }

    public mostrar(){
        System.out.println("ID: " + var2.id + "\nData: " + var2.data + "\nDescricao: " + var2.descricao + "\nOrigem: " + var2.origem);
                if(var2.tipo) System.out.println("Valor: + R$" + var2.valor + "\n");
                else System.out.println("Valor: - R$" + var2.valor + "\n");
    }
}

class Investimento extends Transacao{
    protected LocalDate dataVencimento;
    protected String categoria;
    protected foat rendimento;
    
    public Investimento(int id, float valor, LocalDate dataAplicacao, LocalData dataVencimento,, String descricao, boolean tipo, String origem, String categoria) {
        super(id, valor, dataAplicacao, descricao, tipo, origem); // atributos herdados;
        this.categoria = categoria;
        this.dataVencimento = dataVencimento;
        this.rendimento = rendimento;
    }

    public mostrar(){ // sobrecarga
        System.out.println();
    }

    public float calcularValorAtual() {
        long meses = ChronoUnit.MONTHS.between(this.dataAplicacao, LocalDate.now());
        return (float) (this.valorAplicado * Math.pow(rendimento, meses));
    }

    public float calcularRendimento() {
        return this.calcularValorAtual() - this.valorAplicado;
    }
}


class ContaBanco extends Conta<transacao>{

    public void sincronizar(){ // Temporário (será implementado na classe abstrata pai)

        int id;
        float valor;
        LocalDate data;
        String descricao;
        boolean tipo;
        String origem;

        try {
                List<String> linhas = Files.readAllLines(Paths.get("C:/Users/anacarla/OneDrive/Documentos/Estudo/Ciência da Computação/Disciplinas/4 Período/POO/POO/financas/src/minhasfinancas/openFinance.txt"));

                for (String linha : linhas) {
                if (linha.trim().isEmpty()) continue; // pular linhas vazias

                String[] partes = linha.split(";", -1); // -1 mantém campos vazios

                id = Integer.parseInt(partes[0]);
                valor = Float.parseFloat(partes[1]);
                data = LocalDate.parse(partes[2]);
                descricao = partes[3];
                tipo = Boolean.parseBoolean(partes[4]);
                origem = partes[5];
                
                Transacao t = new Transacao(id, valor, data, descricao, tipo, origem);
                addTransacao(t);
                }

            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo: " + e.getMessage());
            }
    }

    public void gerarExtrato(){
        if (this.transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada.zn");
        } else {
            System.out.println("\n--------- EXTRATO ----------\n");
            Iterator var1 = this.transacoes.iterator();

            while(var1.hasNext()) {
                Transacao var2 = (Transacao)var1.next();
                var2.mostrar();
            }
        }
    }
}

public class ContaCorretora extends Conta<investimento> {


    public void addInvestimento(Investimento var1) {
        this.investimentos.add(var1);
    }

    public void listarInvestimentos() {
        if (this.investimentos.isEmpty()) {
            System.out.println("Nenhum investimento cadastrado na corretora " + this.nome);
        } else {
            System.out.println("Investimentos na corretora " + this.nome + ":");
            Iterator var1 = this.investimentos.iterator();

            while(var1.hasNext()) {
                Investimento var2 = (Investimento)var1.next();
                var2.mostrar();
            }
        }
    }

   // public void sincronizarInvestimentos() {
    //} // Em andamento...
}

