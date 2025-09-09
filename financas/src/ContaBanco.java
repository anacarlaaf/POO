import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class ContaBanco{

    // Atributos
    private int codigoCOMPE;
    private String nome;
    private int numeroConta;
    private String tokenAcesso;

    // Relacionamentos
    private List<Transacao> transacoes;
    // Construtor
    public ContaBanco(int codigoCOMPE, String nome,int numeroConta, String tokenAcesso) {
        this.codigoCOMPE = codigoCOMPE;
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.tokenAcesso = tokenAcesso;

    }

    // Métodos
    public String getNome(){
        return nome;
    }

    public int getNumeroConta(){
        return numeroConta;
    }

    public Integer getCOMPE(){
        return codigoCOMPE;
    }

    private void addTransacao(Transacao novaTransacao){
        this.transacoes.add(novaTransacao);
    }

    //simular sincronização com openFinance
    // public void sincronizar() {
    // }
        
}
    // public Extrato gerarExtrato(Date dataInicio, Date dataFim){

    // }
    

