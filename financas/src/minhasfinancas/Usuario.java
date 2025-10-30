package minhasfinancas;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Usuario {

   // Atributos
   private int id;
   private String nomeCompleto;
   private LocalDate dataNascimento;
   private String cpf;
   private String perfil;
   private String email;
   private List<ContaBanco> contasBancosVinculadas;
   private List<ContaCorretora> contasCorretorasVinculadas;

   // Método Construtor
   public Usuario(int var1, String var2, LocalDate var3, String var4, String var5, String var6) {
      this.id = var1;
      this.nomeCompleto = var2;
      this.dataNascimento = var3;
      this.cpf = var4;
      this.perfil = var5;
      this.email = var6;
      this.contasBancosVinculadas = new ArrayList<>();
      this.contasCorretorasVinculadas = new ArrayList<>();
   }

   public String getCPF() {
      return this.cpf;
   }

   public List<ContaBanco> getContasBanco(){
      return this.contasBancosVinculadas;
   }

   public Integer calcularIdade() {
      LocalDate var1 = LocalDate.now();
      Period var2 = Period.between(this.dataNascimento, var1);
      Integer var3 = var2.getYears();
      //System.out.println("Idade: " + var3 + "\n");
      return var3;
   }

   public void mostrarDados() {
      int var10001 = this.id;
      System.out.println("--------- DADOS DO USUÁRIO ---------\nID: " + var10001 + "\nNome Completo: '" + this.nomeCompleto + "'\nIdade: " + this.calcularIdade() + "\nE-mail: '" + this.email + "'\nPerfil de Investidor: " + this.perfil + "\n");
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public void setPerfil(String var1) {
      this.perfil = var1;
   }

   public void vincularContaBanco(ContaBanco var1) {
      if (this.contasBancosVinculadas.add(var1)) {
         System.out.println("Conta no banco" + var1.getNome() +" adicionada com sucesso!");
      } else {
         System.out.println("Esse conta já está vinculada!");
      }

   }

   public void vincularContaCorretora(ContaCorretora var1) {
      if (this.contasCorretorasVinculadas.add(var1)) {
         System.out.println("\nConta de corretora adicionada com sucesso!\n");
      } else {
         System.out.println("Esse conta já está vinculada!\n");
      }

   }

   public void listarContasBanco() {
      Iterator var1 = this.contasBancosVinculadas.iterator();

      System.out.println("\n--------- BANCOS CADASTRADOS ---------\n");

      while(var1.hasNext()) {
         ContaBanco var2 = (ContaBanco)var1.next();
         PrintStream var10000 = System.out;
         String var10001 = var2.getNome();
         var10000.println("Banco: " + var10001 + "\nCódigo COMPE: " + var2.getCOMPE() + "\n");
      }

   }

   public void listarContasCorretoras() {
      Iterator var1 = this.contasCorretorasVinculadas.iterator();

      while(var1.hasNext()) {
         ContaCorretora var2 = (ContaCorretora)var1.next();
         PrintStream var10000 = System.out;
         String var10001 = var2.getNome();
         var10000.println("Banco: " + var10001 + "\nCódigo COMPE: " + var2.getCodigo() + "\n");
      }

   }
}
