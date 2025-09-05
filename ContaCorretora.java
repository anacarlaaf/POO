import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaCorretora{

    // Atributos
    private int codigo;
    public String nome;
    private String tokenAcesso;

    // Relacionamento
    private List<Investimento> investimentos;

    // Construtor
    public ContaCorretora(int codigo, String nome, String tokenAcesso) {
        this.codigo = codigo;
        this.nome = nome;
        this.tokenAcesso = tokenAcesso;
        this.investimentos = new ArrayList<>();
    }    
    
    // Métodos
    public int getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    private void addInvestimento(Investimento novoInvestimento){
        this.investimentos.add(novoInvestimento);
    }
    public void sincronizarInvestimentos(){} //simular sincronização com openFinance

}


class Investimento {
    int id;
    float valorAplicado;
    float valorAtual;
    Date dataAplicacao;
    Date dataVencimento;
    String categoria;

    // Construtor
    public Investimento(int id, float valorAplicado, Date dataAplicacao, Date dataVencimento, String categoria) {
        this.id = id;
        this.valorAplicado = valorAplicado;
        this.dataAplicacao = dataAplicacao;
        this.dataVencimento = dataVencimento;
        this.categoria = categoria;
    }

    // public float calcularValorAtual(){}
    // public float calcularRendimento(){}

}

