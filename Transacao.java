import java.util.Date;

abstract class Transacao{

    // Categorias
    protected enum tipoRecorrencia{
        MENSAL, QUIZENAL, ANUAL, ESPORADICA
    }

    // Atributos
    protected int id;
    protected float valor;
    protected Date data;
    protected String descricao;

    // Métodos
    public float getValor(){
        return valor;
    }
}

class Entrada extends Transacao{

    // Categorias
    private enum tipoEntrada{
        SALARIO, RENDA_EXTRA, INVESTIMENTO, PASSIVA
    }

    // Atributos
    private tipoEntrada tipoEntrada;
    private FonteRenda origem;

    // Métodos
    public FonteRenda getFonte(){
        return origem;
    }

    public tipoEntrada getTipoEntrada(){
        return tipoEntrada;
    }

    public void setTipoEntrada(tipoEntrada novoTipo){
        this.tipoEntrada = novoTipo;
    }
}

class Saida extends Transacao{

    // Categorias
    private enum categoriaSaida{
        ALIMENTACAO, SAUDE, MORADIA, LAZER, EDUCACAO, TRANSPORTE
    }

    private enum categoriaPagamento{
        CREDITO, DEBITO, PIX, DINHEIRO
    }

    // Atributos
    private categoriaSaida categoria;
    private String origem;
    private categoriaPagamento formaPagamento;

    // Métodos
    public categoriaSaida getSaida(){
        return categoria;
    }
    
    public String getOrigem(){
        return origem;
    }

    public categoriaPagamento getCatPagamento(){
        return formaPagamento;
    }
}

class FonteRenda {

    protected enum tipoRecorrencia{
        MENSAL, QUIZENAL, ANUAL, ESPORADICA
    }
    
    private int id;
    private String nome;
    private tipoRecorrencia recorrencia;

    // Métodos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public tipoRecorrencia getRecorrencia() {
        return recorrencia;
    }
}
