import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Usuario{

     // Categorias
    private enum perfilInvestidor{
        CONSERVADOR, MODERADO, ARROJADO
    }

    // Atributos
    private int id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpf;
    private perfilInvestidor perfil;
    private String email;

    // Relacionamentos
    private List<ContaBanco> contasBancosVinculadas;
    private List<ContaCorretora> contasCorretorasVinculadas;

    // Construtor
    public Usuario(int id, String nomeCompleto, LocalDate dataNascimento, String cpf, perfilInvestidor perfil, String email) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.perfil = perfil;
        this.email = email;
        this.contasBancosVinculadas = new ArrayList<>();
        this.contasCorretorasVinculadas = new ArrayList<>();
    }
    
    // Métodos
    public String getCPF(){
        return cpf;
    }

    public Integer calcularIdade(){
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(this.dataNascimento, hoje);
        Integer idade = periodo.getYears();
        System.out.println("Idade: " + idade + "\n");
        return idade;
    }

    public void mostrarDados(){
        System.out.println("Dados do Usuário" + "\nUsuario{" +
                "ID: " + id +
                "\nNome Completo: '" + nomeCompleto + '\'' +
                "\nIdade: " + calcularIdade() +
                "\nE-mail: '" + email + '\'' +
                "\nPerfil de Investidor: " + perfil);
    }

    public void setEmail(String novoEmail){
        this.email = novoEmail;
    }

    public void setPerfil(perfilInvestidor novoPerfil){
        this.perfil = novoPerfil;        
    }

    public void vincularContaBanco(ContaBanco novaContaBanco){
        if (this.contasBancosVinculadas.add(novaContaBanco)){
            System.out.println("\nConta de banco adicionada com sucesso!\n");
        }
        else {
            System.out.println("\nEsse conta já está vinculada!\n");
        }
    }

    public void vincularContaCorretora(ContaCorretora novacontaCorretora){
        if (this.contasCorretorasVinculadas.add(novacontaCorretora)){
            System.out.println("\nConta de corretora adicionada com sucesso!\n");
        }
        else {
            System.out.println("\nEsse conta já está vinculada!\n");
        }
    }

    public void listarContasBanco(){
       for (ContaBanco conta : this.contasBancosVinculadas) {
            System.out.println("Banco: " + conta.getNome()+
                            "\nCódigo COMPE: " + conta.getCOMPE() + "\n");
        }
    }

    public void listarContasCorretoras(){
        for (ContaCorretora conta : this.contasCorretorasVinculadas) {
            System.out.println("Banco: " + conta.getNome()+
                            "\nCódigo COMPE: " + conta.getCodigo() + "\n");
        }
    }
}