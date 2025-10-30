package minhasfinancas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class ContaCorretora {
   private int codigo;
   public String nome;
   private String tokenAcesso;
   private List<Investimento> investimentos;

   public ContaCorretora(int var1, String var2, String var3) {
      this.codigo = var1;
      this.nome = var2;
      this.tokenAcesso = var3;
      this.investimentos = new ArrayList<>();
   }

   public int getCodigo() {
      return this.codigo;
   }

   public String getNome() {
      return this.nome;
   }

   public void addInvestimento(Investimento var1) {
      this.investimentos.add(var1);
   }

   public void listarInvestimentos() {
      if (this.investimentos.isEmpty()) {
         System.out.println("Nenhum investimento cadastrado na corretora " + this.nome);
      } else {
         System.out.println("Investimentos da corretora " + this.nome + ":");
         Iterator var1 = this.investimentos.iterator();

         while(var1.hasNext()) {
            Investimento var2 = (Investimento)var1.next();
            int var10001 = var2.id;
            System.out.println("- ID: " + var10001 + " | Valor Aplicado: " + var2.valorAplicado + " | Valor Atual: " + var2.calcularValorAtual() + " | Rendimento: " + var2.calcularRendimento());
         }
      }

   }

   // public void sincronizarInvestimentos() {
   //    boolean var1 = (new Random()).nextBoolean();
   //    if (var1) {
   //       System.out.println("Investimentos da corretora " + this.nome + " sincronizados com sucesso!");
   //    } else {
   //       System.out.println("Falha ao sincronizar investimentos da corretora " + this.nome + ".");
   //    }

   // }
}


class Investimento {
   protected int id;
   protected float valorAplicado;
   protected LocalDate dataAplicacao;
   protected LocalDate dataVencimento;
   protected String categoria;

   public Investimento(int var1, float var2, LocalDate var3, LocalDate var4, String var5) {
      this.id = var1;
      this.valorAplicado = var2;
      this.dataAplicacao = var3;
      this.dataVencimento = var4;
      this.categoria = var5;
   }

   public float calcularValorAtual() {
      long meses = ChronoUnit.MONTHS.between(this.dataAplicacao, LocalDate.now());
      return (float) (this.valorAplicado * Math.pow(1.012, meses));
   }


   public float calcularRendimento() {
      return this.calcularValorAtual() - this.valorAplicado;
   }
}

