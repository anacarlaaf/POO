package minhasfinancas;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Usuario {

   // Atributos
   //private int id;
   private String nomeCompleto;
   private LocalDate dataNascimento;
   private String cpf;
   private String perfil;
   private String email;
   private List<ContaBanco> contasBancosVinculadas;
   private List<ContaCorretora> contasCorretorasVinculadas;

   // Método Construtor

   public Usuario(String nome, LocalDate dataNascimento, String cpf, String perfil, String email) {
      // this.id = id; auto-incremento no banco
      this.nomeCompleto = nome;
      this.dataNascimento = dataNascimento;
      this.cpf = cpf;
      this.perfil = perfil;
      this.email = email;
      this.contasBancosVinculadas = new ArrayList<>();
      this.contasCorretorasVinculadas = new ArrayList<>();
   }

   public Usuario cadastrarUsuario(){
      // int id; auto-incremento no banco
      String nomeCompletoL;
      LocalDate dataNascimentoL;
      String cpfL;
      String perfilL;
      String emailL;

      Scanner sc = new Scanner(System.in);
      System.out.println("\n--------- CADASTRO DE USUÁRIO ---------\n");
      System.out.println("Nome Completo: ");
      nomeCompletoL = sc.nextLine();

      System.out.println("\nData de Nascimento: ");
      String entrada = sc.nextLine();
      DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      dataNascimentoL = LocalDate.parse(entrada, formato);
      
      System.out.println("\nCPF: ");
      cpfL = sc.nextLine();

      System.out.println("\nPerfil de investidor: ");
      perfilL = sc.nextLine();

      System.out.println("\nEmail: ");
      emailL = sc.nextLine();
      System.out.println("---------------------------------------\n");
      
      Usuario usuario = new Usuario(nomeCompletoL ,dataNascimentoL, cpfL, perfilL, emailL);
      return usuario;
   }

   public List<ContaBanco> getContasBanco(){
      return this.contasBancosVinculadas;
   }

   public Integer calcularIdade() {
      LocalDate idL = LocalDate.now();
      Period periodo = Period.between(this.dataNascimento, idL);
      Integer idade = periodo.getYears();
      return idade;
   }

   public void mostrarDados() {
      System.out.println("\n------------- SEUS DADOS -------------\nNome Completo: " 
                        + this.nomeCompleto + "\nCPF: " + cpf +"\nIdade: " + calcularIdade() 
                        + "\nE-mail: " + email + "\nPerfil de Investidor: " 
                        + perfil);
      System.out.println("--------------------------------------\n");
   }

   public void vincularContaBanco(ContaBanco id) {
      this.contasBancosVinculadas.add(id);
   }

   public void listarContasBanco() {
      Iterator id = this.contasBancosVinculadas.iterator();

      System.out.println("\n--------- BANCOS CADASTRADOS ---------\n");

      while(id.hasNext()) {
         ContaBanco nome = (ContaBanco)id.next();
         PrintStream id0000 = System.out;
         String id0001 = nome.getNome();
         id0000.println("Banco: " + id0001 + "\nCódigo COMPE: " + nome.getCodigo());
      }

      System.out.println("--------------------------------------\n");

   }
}
