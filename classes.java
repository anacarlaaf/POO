import java.util.Date;

pulic enum perfil{
    CONSERVADOR,
    MODERADO,
    ARROJADO
}

private class Usuario{

    // Atributos
    private int id;
    private String nomeCompleto;
    public String apelido;
    private Date dataNascimento;
    private int idade;
    private String cpf;
    private Enum perfil;
    private String email;

    // Relacionamentos
    // Obs.: trocar por outras estruturas para manter a ordenação e facilitar queries
    private List<contaBanco> contasBancosVinculadas;
    private List<contaCorretora> contasCorretorasVinculadas;
    private List<Meta> metas;
    //private Lista<Relatorio> relatorios;

    
    public void alterarApelido(String novoApelido){
        this.apelido = novoApelido;
    }

    public void alterarEmail(String novoEmail){
        this.email = novoEmail;
    }

    public void alterarPerfil(Enum novoPerfil){
        this.perfil = novoPerfil;        
    }


    public void vincularcontaBanco(contaBanco novocontaBanco){
        this.contaBancosVinculados.add(contaBanco) // add  verificação de vinculação antes de add
    }

    public void vincularcontaCorretora(contaCorretora novacontaCorretora){
        this.contaCorretorasVinculadas.add(novacontaCorretora);
    }
    public void addMeta(Meta novaMeta){
        this.metas.add(novaMeta);
    }

    // Fazer getters e setters
    // - Mostrar metas, investimentos, contaBancos, etc
    // - remover ou editar meta (usar sobrecarga pra editar);

}

private class contaBanco{

    // Atributos
    private int codigoCOMPE; // mesma coisa que o id ou tem um separado??
    public String nome;
    private String numeroConta;
    private String tokeAcesso;

    // Relacionamentos
    private List<Extrato> extratos;
    private List<Gasto> gastos;
    private Lsit<Renda> rendas;

    private void addExtrato(Extrato novoExtrato){
        this.extratos.add(novoExtrato);
    }
    private void addGasto(Gasto novoGasto){
        this.gastos.add(novoGasto);
    }
    private void addRenda(Renda novaRenda){
        this.rendas.add(novaRenda);
    }

    public boolean sincronizarExtrato(){} //???? Teoricamente acessa com o openFinance
    public Extrato obterExtrato(Date dataInicio, Date dataFim){}
    
}

private class Extrato{

}

private class Gasto{

}

private class Investimento{


}

private class Relatorio{

}

private class Meta{
    private String 

}

private class contaCorretora{

    // Atributos
    private int codigo;
    public String nome;
    private tokeAcesso;

    // Relacionamento
    private List<Investimento> investimentos;

    private void addInvestimento(Investimento novoInvestimento){
        this.investimentos.add(novoInvestimento);
    }
    public void sincronizarInvestimentos(){}
    

}

private class Renda{

}