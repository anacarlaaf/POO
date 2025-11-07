package minhasfinancas;
import java.util.*;

public class ContaCorretora extends Conta<Investimento> {

    public ContaCorretora(int codigo, String nome, int numeroConta) {
        super(codigo, nome, numeroConta); // Chama o construtor da classe pai
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

    @Override
    public void sincronizar() {
        // Em construção
    }
}

