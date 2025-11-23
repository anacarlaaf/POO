package minhasfinancas;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Representa um usuário do sistema de finanças pessoais, contendo
 * informações pessoais e suas contas bancárias e corretoras vinculadas.
 *
 * A classe permite cadastrar um usuário, vincular contas e exibir dados
 * pessoais formatados.
 */
public class Usu {

    // ========================= Atributos ===============================

    /** Nome completo do usuário. */
    private String nomeCompleto;

    /** Data de nascimento do usuário. */
    private LocalDate dataNascimento;

    /** CPF do usuário. */
    private String cpf;

    /** Perfil de investidor (ex.: conservador, moderado, arrojado). */
    private String perfil;

    /** Endereço de e-mail do usuário. */
    private String email;

    /** Lista de contas bancárias vinculadas ao usuário. */
    private List<ContaBanco> contasBancosVinculadas;

    /** Lista de contas corretoras vinculadas ao usuário. */
    private List<ContaCorretora> contasCorretorasVinculadas;

    // ====================== Construtor ================================

    /**
     * Cria um novo usuário com os dados fornecidos.
     *
     * @param nome Nome completo do usuário.
     * @param dataNascimento Data de nascimento.
     * @param cpf CPF do usuário.
     * @param perfil Perfil de investidor.
     * @param email Endereço de e-mail.
     */
    public Usuario(String nome, LocalDate dataNascimento, String cpf, String perfil, String email) {
        this.nomeCompleto = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.perfil = perfil;
        this.email = email;
        this.contasBancosVinculadas = new ArrayList<>();
        this.contasCorretorasVinculadas = new ArrayList<>();
    }

    // ====================== Métodos ==================================

    /**
     * Realiza o cadastro de um novo usuário por meio de entradas digitadas
     * no console. Solicita nome completo, data de nascimento, CPF,
     * perfil de investidor e e-mail.
     *
     * @return Um novo objeto {@code Usuario} preenchido com as informações
     *         fornecidas pelo usuário.
     */
    public Usuario cadastrarUsuario() {
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

        return new Usuario(nomeCompletoL, dataNascimentoL, cpfL, perfilL, emailL);
    }

    /**
     * Obtém a lista de contas bancárias vinculadas ao usuário.
     *
     * @return Lista contendo objetos {@code ContaBanco}.
     */
    public List<ContaBanco> getContasBanco() {
        return this.contasBancosVinculadas;
    }

    /**
     * Calcula a idade atual do usuário com base na data de nascimento.
     *
     * @return Idade em anos completos.
     */
    public Integer calcularIdade() {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(this.dataNascimento, hoje);
        return periodo.getYears();
    }

    /**
     * Exibe no console os dados principais do usuário, incluindo nome,
     * CPF, idade, e-mail e perfil de investidor.
     */
    public void mostrarDados() {
        System.out.println("\n------------- SEUS DADOS -------------\nNome Completo: "
                + this.nomeCompleto + "\nCPF: " + cpf + "\nIdade: " + calcularIdade()
                + "\nE-mail: " + email + "\nPerfil de Investidor: " + perfil);
        System.out.println("--------------------------------------\n");
    }

    /**
     * Adiciona uma conta bancária à lista de contas vinculadas ao usuário.
     *
     * @param conta Conta bancária a ser vinculada.
     */
    public void vincularContaBanco(ContaBanco conta) {
        this.contasBancosVinculadas.add(conta);
    }

    /**
     * Lista no console todas as contas bancárias vinculadas ao usuário,
     * exibindo nome do banco e código COMPE.
     */
    public void listarContasBanco() {
        Iterator<ContaBanco> id = this.contasBancosVinculadas.iterator();

        System.out.println("\n--------- BANCOS CADASTRADOS ---------\n");

        while (id.hasNext()) {
            ContaBanco banco = id.next();
            System.out.println("Banco: " + banco.getNome() +
                               "\nCódigo COMPE: " + banco.getCodigo());
        }

        System.out.println("--------------------------------------\n");
    }
}

