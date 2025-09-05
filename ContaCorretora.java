import java.util.Date;
import java.util.List;

public class ContaCorretora{

    // Atributos
    private int codigo;
    public String nome;
    private String tokenAcesso;

    // Relacionamento
    private List<Investimento> investimentos;
    
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
    Date dataAplicacao;
    Date dataVencimento;
    String categoria;

    // public float calcularValorAtual(){}
    // public float calcularRendimento(){}
}

