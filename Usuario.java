import java.util.Date;
import java.util.List;

public class Usuario{

    private enum perfilInvestidor{
        CONSERVADOR, MODERADO, ARROJADO
    }

    // Atributos
    private int id;
    private String nomeCompleto;
    private String apelido;
    private Date dataNascimento;
    private int idade;
    private String cpf;
    private perfilInvestidor perfil;
    private String email;

    // Relacionamentos
    // Obs.: trocar por outras estruturas para manter a ordenação e facilitar queries
    private List<ContaBanco> contasBancosVinculadas;
    private List<ContaCorretora> contasCorretorasVinculadas;
    private List<Meta> metas;
    //private Lista<Relatorio> relatorios;

    
    public void alterarApelido(String novoApelido){
        this.apelido = novoApelido;
    }

    public void alterarEmail(String novoEmail){
        this.email = novoEmail;
    }

    public void alterarPerfil(perfilInvestidor novoPerfil){
        this.perfil = novoPerfil;        
    }

    public void vincularcontaBanco(ContaBanco novaContaBanco){
        this.contasBancosVinculadas.add(novaContaBanco); // add  verificação de vinculação antes de add
    }

    public void vincularcontaCorretora(ContaCorretora novacontaCorretora){
        this.contasCorretorasVinculadas.add(novacontaCorretora);
    }
    public void addMeta(Meta novaMeta){
        this.metas.add(novaMeta);
    }

    // Fazer getters e setters
    // - Mostrar metas, contaBancos, etc
    // - remover ou editar meta (usar sobrecarga pra editar);
}