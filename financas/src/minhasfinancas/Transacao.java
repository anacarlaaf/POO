package minhasfinancas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Representa uma transação financeira genérica, que pode ser positiva
 * (receita) ou negativa (despesa).
 *
 * <p>Cada transação contém valor, data, descrição, categoria e origem.
 * Esta classe é utilizada tanto por contas bancárias quanto por
 * aplicações de investimentos.</p>
 */
class Transacao {

    /** Valor da transação. Pode ser positivo (receita) ou negativo (despesa). */
    protected float valor;

    /** Data em que a transação ocorreu. */
    protected LocalDate data;

    /** Descrição da transação (ex.: "Supermercado", "Salário"). */
    protected String descricao;

    /** Categoria da transação (ex.: "Alimentação", "Renda"). */
    protected String categoria;

    /** Origem da transação (ex.: "Cartão", "Transferência"). */
    protected String origem;

    /**
     * Retorna o valor da transação.
     *
     * @return valor em float.
     */
    public float getValor() {
        return valor;
    }

    /**
     * Retorna a categoria da transação.
     *
     * @return categoria como String.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Construtor que cria uma transação financeira.
     *
     * @param valor valor da transação.
     * @param data data em que ocorreu.
     * @param descricao texto descritivo.
     * @param categoria categoria financeira.
     * @param origem origem da transação.
     */
    public Transacao(float valor, LocalDate data, String descricao, String categoria, String origem) {
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.origem = origem;
    }

    /**
     * Exibe no console as informações da transação.
     * <p>Formatos:</p>
     * <ul>
     *   <li>Valor positivo → "+ R$"</li>
     *   <li>Valor negativo → "- R$"</li>
     * </ul>
     */
    public void mostrar() {
        System.out.println("\nData: " + data 
                         + "\nDescricao: " + descricao
                         + "\nOrigem: " + origem
                         + "\nCategoria: " + categoria + "\n");

        if (valor > 0)
            System.out.println("Valor: + R$" + valor + "\n");
        else
            System.out.println("Valor: - R$" + valor + "\n");
    }
}

/**
 * Representa um investimento financeiro, que é uma especialização da classe
 * {@link Transacao}. A transação de investimento cresce ao longo do tempo
 * conforme seu rendimento mensal.
 */
class Investimento extends Transacao {

    /** Data de vencimento do investimento. */
    protected LocalDate dataVencimento;

    /** Taxa de rendimento mensal (ex.: 1.01 representa 1% ao mês). */
    protected float rendimento;

    /**
     * Construtor de um investimento financeiro.
     *
     * @param id (não utilizado – reservado para futura persistência)
     * @param valor valor aplicado.
     * @param dataAplicacao data inicial do investimento.
     * @param dataVencimento data final (resgate).
     * @param descricao descrição da aplicação.
     * @param categoria categoria financeira.
     * @param origem origem da aplicação.
     * @param rendimento taxa de rendimento mensal.
     */
    public Investimento(int id, float valor, LocalDate dataAplicacao,
                        LocalDate dataVencimento, String descricao,
                        String categoria, String origem, float rendimento) {

        super(valor, dataAplicacao, descricao, categoria, origem);
        this.dataVencimento = dataVencimento;
        this.rendimento = rendimento;
    }

    /**
     * Calcula o valor atual do investimento, considerando a quantidade de
     * meses entre a data de aplicação e o momento presente.
     *
     * @return valor atualizado do investimento.
     */
    public float calcularValorAtual() {
        long meses = ChronoUnit.MONTHS.between(this.data, LocalDate.now());
        return (float) (valor * Math.pow(rendimento, meses));
    }

    /**
     * Calcula o rendimento (lucro) acumulado até o momento.
     *
     * @return valor de rendimento total.
     */
    public float calcularRendimento() {
        return this.calcularValorAtual() - valor;
    }

    /**
     * Exibe informações detalhadas do investimento no console.
     * Inclui valor aplicado, valor atual, rendimento acumulado,
     * data de aplicação e vencimento.
     */
    @Override
    public void mostrar() {
        System.out.println("\nDescricao: " + descricao
                         + "\nOrigem: " + origem
                         + "\nData de Aplicação: " + data
                         + "\nData de vencimento: " + dataVencimento
                         + "\nRendimento: " + rendimento
                         + "\nValor aplicado: " + valor 
                         + "Valor Atual: " + calcularValorAtual()
                         + "Rendimento Atual: " + calcularRendimento()
                         + "\n");
    }
}
