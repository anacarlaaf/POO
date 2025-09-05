import java.time.LocalDate;

abstract class Transacao{

    // Atributos
    protected int id;
    protected float valor;
    protected LocalDate data;
    protected String descricao;

    // Métodos
    public float getValor(){
        return valor;
    }

    // Construtor
    public Transacao(int id, float valor, LocalDate data, String descricao) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }
}

class Entrada extends Transacao{    

    // Atributos
    private Enum.categoriaEntrada tEntrada;
    private FonteRenda origem;

    // Construtor
    public Entrada(int id, float valor, LocalDate data, String descricao, Enum.categoriaEntrada novaCEntrada, FonteRenda origem) {
        super(id, valor, data, descricao);
        this.tEntrada = novaCEntrada;
        this.origem = origem;
    }

    // Métodos
    public FonteRenda getFonte(){
        return origem;
    }

    public Enum.categoriaEntrada getTipoEntrada(){
        return tEntrada;
    }

    public void setTipoEntrada(Enum.categoriaEntrada novoTipo){
        this.tEntrada = novoTipo;
    }
}

class Saida extends Transacao{    

    // Atributos
    private Enum.categoriaSaida categoria;
    private String origem;
    private Enum.categoriaPagamento formaPagamento;
    
    // Construtor
    public Saida(int id, float valor, LocalDate data, String descricao, Enum.categoriaSaida categoria, String origem, Enum.categoriaPagamento formaPagamento) {
        super(id, valor, data, descricao);
        this.categoria = categoria;
        this.origem = origem;
        this.formaPagamento = formaPagamento;
    }

    // Métodos
    public Enum.categoriaSaida getSaida(){
        return categoria;
    }
    
    public String getOrigem(){
        return origem;
    }

    public Enum.categoriaPagamento getCatPagamento(){
        return formaPagamento;
    }
}

class FonteRenda {

    private int id;
    private String nome;
    private Enum.tipoRecorrencia recorrencia;

    // Construtor
    public FonteRenda(int id, String nome, Enum.tipoRecorrencia recorrencia) {
        this.id = id;
        this.nome = nome;
        this.recorrencia = recorrencia;
    }

    // Métodos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Enum.tipoRecorrencia getRecorrencia() {
        return recorrencia;
    }
}
