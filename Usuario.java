import java.util.Date;
import java.util.List;

public class Usuario{

     // Categorias
    private enum perfilInvestidor{
        CONSERVADOR, MODERADO, ARROJADO
    }

    // Atributos
    private int id;
    private String nomeCompleto;
    private Date dataNascimento;
    private Integer cpf;
    private perfilInvestidor perfil;
    private String email;

    // Relacionamentos
    private List<ContaBanco> contasBancosVinculadas;
    private List<ContaCorretora> contasCorretorasVinculadas;
    
    // Métodos
    public Integer getCPF(){
        return cpf;
    }

    public Integer calcularIdade(){
        Date hoje = new Date();
        long diff = hoje.getTime() - this.dataNascimento.getTime();
        Integer idade = (int) (diff / (1000L * 60 * 60 * 24 * 365));
        System.out.println("Idade: "+ idade + "\n");
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