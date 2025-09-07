import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate; // pega a data de hoje
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

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

     // Listar todos os investimentos
    public void listarInvestimentos() {
        if (investimentos.isEmpty()) {
            System.out.println("Nenhum investimento cadastrado na corretora " + nome);
        } else {
            System.out.println("Investimentos da corretora " + nome + ":");
            for (Investimento inv : investimentos) {
                System.out.println("- ID: " + inv.id 
                    + " | Valor Aplicado: " + inv.valorAplicado 
                    + " | Valor Atual: " + inv.calcularValorAtual()
                    + " | Rendimento: " + inv.calcularRendimento());
            }
        }
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
            LocalDate inicio = dataAplicacao.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long meses = ChronoUnit.MONTHS.between(inicio, LocalDate.now());
            return (float) (valorAplicado * Math.pow(1.012, meses));
    }

    public float calcularRendimento() {
        return calcularValorAtual() - valorAplicado;
    }
}



