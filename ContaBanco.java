import java.util.Date;
import java.util.List;

class ContaBanco{

    // Atributos
    private int codigoCOMPE; // mesma coisa que o id ou tem um separado??
    public String nome;
    private String numeroConta;
    private String tokeAcesso;

    // Relacionamentos
    private List<Extrato> extratos;
    private List<Gasto> gastos;
    private List<Entrada> Entradas;

    private void addExtrato(Extrato novoExtrato){
        this.extratos.add(novoExtrato);
    }
    private void addGasto(Gasto novoGasto){
        this.gastos.add(novoGasto);
    }
    private void addEntrada(Entrada novaEntrada){
        this.Entradas.add(novaEntrada);
    }

    // public boolean sincronizarExtrato(){} //???? Teoricamente acessa com o openFinance
    // public Extrato obterExtrato(Date dataInicio, Date dataFim){}
    
}
