package minhasfinancas;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Transacao {
    //protected int id; // auto-incremento no BD
    protected float valor;
    protected LocalDate data;
    protected String descricao;
    protected String categoria;
    protected String origem;

    public float getValor(){
        return valor;
    }

    public String getCategoria(){
        return categoria;
    }

    public Transacao(float valor, LocalDate data, String descricao, String categoria, String origem) {
        //this.id = id; // auto-incremento no BD
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.origem = origem;
    }

    public void mostrar(){
        System.out.println("\nData: " + data + "\nDescricao: " 
                            + descricao + "\nOrigem: " + origem
                            + "\nCategoria: " + categoria + "\n");
        if(valor>0) System.out.println("Valor: + R$" + valor + "\n");
        else System.out.println("Valor: - R$" + valor + "\n");
    }
}

class Investimento extends Transacao{
    protected LocalDate dataVencimento;
    protected float rendimento;
    
    public Investimento(int id, float valor, LocalDate dataAplicacao, 
                        LocalDate dataVencimento, String descricao, 
                        String categoria, String origem, float rendimento) {
        super(valor, dataAplicacao, descricao, categoria, origem); // Atributos herdados;
        this.dataVencimento = dataVencimento;
        this.rendimento = rendimento;
    }

    public float calcularValorAtual() {
        long meses = ChronoUnit.MONTHS.between(this.data, LocalDate.now());
        return (float) (valor* Math.pow(rendimento, meses));
    }

    public float calcularRendimento() {
        return this.calcularValorAtual() - valor;
    }

    @Override
    public void mostrar(){ // Sobrescrita
        System.out.println("\nDescricao: " + descricao 
                            + "\nOrigem: " + origem + "\nData de Aplicação: " + data
                            + "\nData de vencimento: " + dataVencimento
                            + "\nRendimento: " + rendimento + "\nValor aplicado: "
                            + valor + "Valor Atual" + calcularValorAtual()
                            + "Rendimento Atual: " + calcularRendimento() + "\n");
    }
}
