package minhasfinancas;

import java.util.*;

/**
 * Representa uma conta de corretora vinculada ao usuário.
 *
 * <p>Esta classe herda de {@link Conta} e utiliza {@link Investimento}
 * como tipo de transação. Ela permite registrar investimentos,
 * listá-los e futuramente sincronizar dados com APIs externas.</p>
 */
public class ContaCorretora extends Conta<Investimento> {

    /**
     * Construtor da conta de corretora.
     *
     * @param codigo Código identificador da corretora.
     * @param nome Nome da corretora.
     * @param numeroConta Número da conta do usuário na corretora.
     */
    public ContaCorretora(int codigo, String nome, int numeroConta) {
        super(codigo, nome, numeroConta);
    }

    /**
     * Adiciona um investimento à lista de transações da corretora.
     *
     * @param investimento objeto {@link Investimento} a ser adicionado.
     */
    public void addInvestimento(Investimento investimento) {
        this.transacoes.add(investimento);
    }

    /**
     * Lista todos os investimentos cadastrados na corretora.
     *
     * <p>Caso não haja investimentos, exibe uma mensagem informativa.
     * Se houver, cada investimento é exibido utilizando seu método
     * {@link Investimento#mostrar()}.</p>
     */
    public void listarInvestimentos() {package minhasfinancas;
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


        if (this.transacoes.isEmpty()) {
            System.out.println("Nenhum investimento cadastrado na corretora " + this.nome);
        } else {
            System.out.println("Investimentos na corretora " + this.nome + ":");

            Iterator<Investimento> it = this.transacoes.iterator();
            while (it.hasNext()) {
                Investimento invest = it.next();
                invest.mostrar();
            }
        }
    }

    /**
     * Método sobrescrito responsável por sincronizar os dados da conta.
     *
     * <p>Atualmente, não possui implementação e está marcado como
     * "Em construção". Futuramente deverá sincronizar investimentos
     * com alguma API de mercado financeiro.</p>
     */
    @Override
    public void sincronizar() {
        // Em construção
    }
}
