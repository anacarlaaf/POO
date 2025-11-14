package minhasfinancas;
import java.util.*;

/**
 * Classe abstrata que representa uma conta genérica no sistema financeiro.
 * 
 * <p>Uma conta possui código identificador, nome, número da conta,
 * saldo e um token de acesso. Além disso, mantém uma lista de transações
 * genéricas do tipo {@code T}, permitindo que subclasses definam o tipo
 * específico de transações armazenadas.</p>
 *
 * <p>Esta classe serve como base para contas bancárias, contas de corretora
 * ou qualquer outro tipo de conta financeira que compartilhe essas
 * características.</p>
 *
 * @param <T> Tipo das transações armazenadas na conta.
 */
abstract class Conta<T> {

    /** Código identificador da conta (por exemplo, código COMPE). */
    protected int codigo;

    /** Nome da instituição ou conta (ex.: Banco X, Corretora Y). */
    protected String nome;

    /** Número da conta. */
    protected int numeroConta;

    /** Saldo atual da conta. */
    protected double saldo;

    /** Token ou chave de acesso da conta (se houver integração externa). */
    protected String tokenAcesso;

    /** Lista de transações associadas à conta. */
    protected List<T> transacoes;

    /**
     * Construtor padrão da classe Conta.
     * <p>Inicializa o objeto sem parâmetros explícitos.</p>
     */
    public Conta() {}

    /**
     * Construtor que cria uma conta com código, nome e número.
     *
     * @param codigo Código identificador da conta.
     * @param nome Nome da instituição ou descrição da conta.
     * @param numeroConta Número da conta.
     */
    public Conta(int codigo, String nome, int numeroConta) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.transacoes = new ArrayList<>();
    }

    /**
     * Retorna o nome da instituição ou conta.
     *
     * @return Nome da conta.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Obtém o código identificador da conta.
     *
     * @return Código da conta.
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Retorna o saldo atual da conta.
     *
     * @return Saldo disponível.
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Adiciona uma transação à lista de transações da conta.
     *
     * @param transacao Objeto representando a transação a ser adicionada.
     */
    public void addTransacao(T transacao) {
        this.transacoes.add(transacao);
    }

    /**
     * Método abstrato responsável por sincronizar os dados da conta.
     * 
     * <p>Implementações concretas podem realizar operações como:</p>
     * <ul>
     *   <li>Atualizar saldo a partir de APIs externas</li>
     *   <li>Sincronizar transações</li>
     *   <li>Validar dados de integração</li>
     * </ul>
     *
     * <p>Subclasses devem definir o comportamento específico.</p>
     */
    public abstract void sincronizar();
}
