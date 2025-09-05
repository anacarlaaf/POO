import java.util.List;

class ContaBanco{

    // Atributos
    private int codigoCOMPE;
    public String nome;
    private String numeroConta;
    private String tokenAcesso;

    // Relacionamentos
    private List<Saida> saidas;
    private List<Entrada> entradas;

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
