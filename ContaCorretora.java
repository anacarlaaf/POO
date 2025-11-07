package minhasfinancas;
import java.util.*;

public class ContaCorretora extends Conta<Investimento> {

    public ContaCorretora(int codigo, String nome, int numeroConta, String tokenAcesso) {
        super(codigo, nome, numeroConta, tokenAcesso); // Chama o construtor da classe pai
    }

    public void addInvestimento(Investimento var1) {
        this.transacoes.add(var1);
    }

    public void listarInvestimentos() {
        if (this.transacoes.isEmpty()) {
            System.out.println("Nenhum investimento cadastrado na corretora " + this.nome);
        } else {
            System.out.println("Investimentos na corretora " + this.nome + ":");
            Iterator var1 = this.transacoes.iterator();

            while(var1.hasNext()) {
                Investimento var2 = (Investimento)var1.next();
                var2.mostrar();
            }
        }
    }

   // public void sincronizarInvestimentos() {
    //} // Em andamento...
}

