import java.util.List;

public class ContaCorretora{

    // Atributos
    private int codigo;
    public String nome;
    private String tokenAcesso;

    // Relacionamento
    private List<Investimento> investimentos;
    
    private void addInvestimento(Investimento novoInvestimento){
        this.investimentos.add(novoInvestimento);
    }
    public void sincronizarInvestimentos(){}

}
