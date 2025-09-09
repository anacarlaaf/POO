import java.time.LocalDate;

abstract class Transacao{

    // Atributos
    private int id;
    private float valor;
    private LocalDate data;
    private String descricao;
    private boolean tipo;
    private String origem;

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
