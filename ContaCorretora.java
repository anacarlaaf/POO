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
   //simular sincronização com openFinance
    public void sincronizarInvestimentos() {
        boolean sucesso = new java.util.Random().nextBoolean();
        if (sucesso) {
            System.out.println("Investimentos da corretora " + nome + " sincronizados com sucesso!");
        } else {
            System.out.println("Falha ao sincronizar investimentos da corretora " + nome + ".");
        }
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

   // Crescimento de 1,2% ao mês
    public float calcularValorAtual() {
        long meses = ChronoUnit.MONTHS.between(dataAplicacao, LocalDate.now());
        return (float) (valorAplicado * Math.pow(1.012, meses));
    }

    public float calcularRendimento() {
        return calcularValorAtual() - valorAplicado;
    }
}


