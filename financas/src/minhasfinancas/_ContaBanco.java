package minhasfinancas;
import java.time.LocalDate;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ContaBanco {
   private int codigoCOMPE;
   private String nome;
   private int numeroConta;
   private String tokenAcesso;
   private List<Transacao> transacoes;

   public ContaBanco(int var1, String var2, int var3, String var4) {
      this.codigoCOMPE = var1;
      this.nome = var2;
      this.numeroConta = var3;
      this.tokenAcesso = var4;

      this.transacoes = new ArrayList<>();
   }

   public String getNome() {
      return this.nome;
   }

   public int getNumeroConta() {
      return this.numeroConta;
   }

   public Integer getCOMPE() {
      return this.codigoCOMPE;
   }

   private void addTransacao(Transacao var1) {
      this.transacoes.add(var1);
   }

   public void sincronizar(){

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
            System.out.println("ID: " + var2.id + "\nData: " + var2.data + "\nDescricao: " + var2.descricao + "\nOrigem: " + var2.origem);
            if(var2.tipo) System.out.println("Valor: + R$" + var2.valor + "\n");
            else System.out.println("Valor: - R$" + var2.valor + "\n");
         }
      }
   }
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
}
