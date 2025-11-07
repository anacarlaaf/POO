package minhasfinancas;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

class Transacao {
    protected int id;
    protected float valor;
    protected LocalDate data;
    protected String descricao;
    protected boolean tipo;
    protected String origem;

    public Transacao(int id, float valor, LocalDate data, String descricao, boolean tipo, String origem) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.tipo = tipo;
        this.origem = origem;
    }

    public void mostrar(){
        System.out.println("ID: " + id + "\nData: " + data + "\nDescricao: " + descricao + "\nOrigem: " + origem);
                if(tipo) System.out.println("Valor: + R$" + valor + "\n");
                else System.out.println("Valor: - R$" + valor + "\n");
    }
}

class Investimento extends Transacao{
    protected LocalDate dataVencimento;
    protected String categoria;
    protected float rendimento;
    
    public Investimento(int id, float valor, LocalDate dataAplicacao, LocalDate dataVencimento, String descricao, boolean tipo, String origem, String categoria) {
        super(id, valor, dataAplicacao, descricao, tipo, origem); // atributos herdados;
        this.categoria = categoria;
        this.dataVencimento = dataVencimento;
        this.rendimento = rendimento;
    }

    public void mostrar(){ // sobrecarga
        System.out.println();
    }

    public float calcularValorAtual() {
        long meses = ChronoUnit.MONTHS.between(this.data, LocalDate.now());
        return (float) (valor* Math.pow(rendimento, meses));
    }

    public float calcularRendimento() {
        return this.calcularValorAtual() - valor;
    }
}
