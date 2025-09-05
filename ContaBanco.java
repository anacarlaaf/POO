import java.util.ArrayList;
import java.util.List;

class ContaBanco{

    // Atributos
    private int codigoCOMPE;
    private String nome;
    private String numeroConta;
    private String tokenAcesso;

    // Relacionamentos
    private List<Saida> saidas;
    private List<Entrada> entradas;

    // Construtor
    public ContaBanco(int codigoCOMPE, String nome, String numeroConta, String tokenAcesso) {
        this.codigoCOMPE = codigoCOMPE;
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.tokenAcesso = tokenAcesso;
        this.saidas = new ArrayList<>();
        this.entradas = new ArrayList<>();
    }

    // Métodos
    public String getNome(){
        return nome;
    }

    public String getNumeroConta(){
        return numeroConta;
    }

    public Integer getCOMPE(){
        return codigoCOMPE;
    }

    private void addGasto(Saida novoGasto){
        this.saidas.add(novoGasto);
    }
    private void addEntrada(Entrada novaEntrada){
        this.entradas.add(novaEntrada);
    }

    // public boolean sincronizar(){} //simular sincronização com openFinance
    // public Extrato gerarExtrato(Date dataInicio, Date dataFim){}
    
}
