package minhasfinancas;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Representa uma conta bancária vinculada ao usuário.
 *
 * <p>Esta classe herda de {@link Conta} e trabalha com transações do tipo
 * {@link Transacao}. Ela implementa métodos para cadastrar bancos,
 * sincronizar transações a partir de arquivos simulando a API OpenFinance,
 * além de gerar e abrir um dashboard financeiro com dados atualizados.</p>
 */
public class ContaBanco extends Conta<Transacao> {

    /**
     * Construtor padrão da classe ContaBanco.
     * <p>Cria uma instância vazia.</p>
     */
    public ContaBanco() {}

    /**
     * Construtor que cria uma conta bancária com código, nome e número da conta.
     *
     * @param codigo Código COMPE ou identificador da instituição bancária.
     * @param nome Nome do banco.
     * @param numeroConta Número da conta do usuário no banco.
     */
    public ContaBanco(int codigo, String nome, int numeroConta) {
        super(codigo, nome, numeroConta);
    }

    /**
     * Realiza o cadastro de uma conta bancária a partir de entrada pelo console.
     *
     * @return Um novo objeto {@code ContaBanco} preenchido com código, nome e número da conta.
     */
    public ContaBanco CadastrarBanco() {
        int codigoL;
        String nomeL;
        int numeroContaL;

        Scanner sc = new Scanner(System.in);
        System.out.println("\n--------- CADASTRO DE BANCO ---------\n");

        System.out.println("Código: ");
        codigoL = sc.nextInt();

        System.out.println("Nome do Banco: ");
        nomeL = sc.nextLine();

        System.out.println("Número da Conta: ");
        numeroContaL = sc.nextInt();

        System.out.println("\n-------------------------------------\n");
        return new ContaBanco(codigoL, nomeL, numeroContaL);
    }

    /**
     * Sincroniza os dados da conta bancária lendo o arquivo
     * {@code financas/data/openFinance.txt}.
     *
     * <p>Cada linha do arquivo representa uma transação com os seguintes campos:</p>
     * <ul>
     *   <li>valor (float)</li>
     *   <li>data (ISO: yyyy-MM-dd)</li>
     *   <li>descrição</li>
     *   <li>categoria</li>
     *   <li>origem</li>
     * </ul>
     *
     * <p>A sincronização atualiza o saldo da conta e adiciona novas transações
     * à lista local.</p>
     *
     * @throws RuntimeException se ocorrer erro de leitura do arquivo.
     */
    @Override
    public void sincronizar() {
        float valor;
        LocalDate data;
        String descricao;
        String categoria;
        String origem;

        try {
            List<String> linhas = Files.readAllLines(Paths.get("financas/data/openFinance.txt"));

            for (String linha : linhas) {
                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(";", -1);

                valor = Float.parseFloat(partes[0]);
                data = LocalDate.parse(partes[1]);
                descricao = partes[2];
                categoria = partes[3];
                origem = partes[4];

                this.saldo += valor;

                Transacao t = new Transacao(valor, data, descricao, categoria, origem);
                addTransacao(t);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    /**
     * Gera informações financeiras agregadas (saldo, receita, despesa e
     * gastos por categoria) e salva tudo em um arquivo CSV
     * {@code financas/data/dashboard_info.csv}.
     *
     * <p>Este método é usado internamente antes da geração do dashboard.</p>
     */
    private void gerarDashboardInfo() {
        sincronizar();

        Map<String, Float> gastosPorCategoria = new HashMap<>();
        float receita = 0, despesa = 0;

        for (Transacao t : this.transacoes) {
            if (t.getValor() >= 0) {
                receita += t.getValor();
            }
            if (t.getValor() < 0) {
                despesa += t.getValor();
                String categoria = t.getCategoria();
                float valor = Math.abs(t.getValor());

                gastosPorCategoria.put(categoria,
                    gastosPorCategoria.getOrDefault(categoria, 0f) + valor
                );
            }
        }

        try (PrintWriter pw = new PrintWriter("financas/data/dashboard_info.csv")) {
            pw.println("Saldo " + saldo);
            pw.println("Receita " + receita);
            pw.println("Despesa " + despesa);

            for (Map.Entry<String, Float> entry : gastosPorCategoria.entrySet()) {
                pw.println(entry.getKey() + " " + entry.getValue());
            }

        } catch (Exception e) {
            System.err.println("Erro ao gerar CSV: " + e.getMessage());
        }
    }

    /**
     * Gera e abre um dashboard interativo usando Streamlit.
     *
     * <p>O método:</p>
     * <ol>
     *   <li>Gera o CSV com dados atualizados</li>
     *   <li>Executa o script Python {@code dashboard.py}</li>
     *   <li>Abre o dashboard no navegador</li>
     *   <li>Aguarda o usuário pressionar ENTER para encerrar</li>
     * </ol>
     *
     * @throws RuntimeException se houver erro ao executar o Streamlit.
     */
    public void gerarDashboard() {
        gerarDashboardInfo();

        try {
            System.out.println("Iniciando dashboard Streamlit.");

            ProcessBuilder pb = new ProcessBuilder("streamlit", "run",
                "financas/src/minhasfinancas/dashboard.py");

            Process process = pb.start();

            Thread.sleep(2000);

            System.out.println("http://localhost:8502");
            System.out.println("Pressione ENTER para voltar ao menu.");

            new Scanner(System.in).nextLine();

            process.destroy();

        } catch (IOException e) {
            System.err.println("Erro ao executar script Python: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Execução interrompida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
