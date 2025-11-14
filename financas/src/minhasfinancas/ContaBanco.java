package minhasfinancas;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class ContaBanco extends Conta<Transacao>{

    public ContaBanco(){};

    public ContaBanco(int codigo, String nome, int numeroConta) {
        super(codigo, nome, numeroConta); // Chama o construtor da classe pai
    }

    public ContaBanco CadastrarBanco(){
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
        ContaBanco conta = new ContaBanco(codigoL, nomeL, numeroContaL);
        return conta;
    }

    @Override
    public void sincronizar(){ // Simula requisição à API OpenFinance

        float valor;
        LocalDate data;
        String descricao;
        String categoria;
        String origem;

        try {
                List<String> linhas = Files.readAllLines(Paths.get("financas/data/openFinance.txt"));

                for (String linha : linhas) {
                    if (linha.trim().isEmpty()) continue; // Pula linhas vazias

                    String[] partes = linha.split(";", -1);

                    valor = Float.parseFloat(partes[0]);
                    data = LocalDate.parse(partes[1]);
                    descricao = partes[2];
                    categoria = partes[3];
                    origem = partes[4];
                    this.saldo += valor; // Atualiza saldo
                    
                    Transacao t = new Transacao(valor, data, descricao, categoria, origem);
                    addTransacao(t);
                }

            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo: " + e.getMessage());
            }
    }

    private void gerarDashboardInfo() {
        sincronizar();

        // Map para acumular total por categoria
        Map<String, Float> gastosPorCategoria = new HashMap<>();
        float receita = 0, despesa = 0;

        for (Transacao t : this.transacoes) {
            if (t.getValor() >= 0) {
                receita += t.getValor();
            }
            if (t.getValor() < 0) { // Só gastos (valores negativos)
                despesa += t.getValor();
                String categoria = t.getCategoria();
                float valor = Math.abs(t.getValor()); // torna positivo para somar

                gastosPorCategoria.put(categoria,
                    gastosPorCategoria.getOrDefault(categoria, 0f) + valor
                );
            }
        }

        // Agora escrevemos em CSV
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

    public void gerarDashboard(){
        gerarDashboardInfo();

        try {
            System.out.println("Iniciando dashboard Streamlit...");
            
            // Usar ProcessBuilder para melhor controle
            ProcessBuilder pb = new ProcessBuilder("streamlit", "run", "financas/src/minhasfinancas/dashboard.py");
            
            // Iniciar o processo sem esperar (em background)
            Process process = pb.start();
            
            // Aguardar um pouco para o Streamlit inicializar
            Thread.sleep(2000);
            
            System.out.println("http://localhost:8502");
            System.out.println("Pressione ENTER para voltar ao menu...");
            
            // Esperar o usuário pressionar ENTER para finalizar
            new Scanner(System.in).nextLine();
            
            // Finalizar o processo do Streamlit
            process.destroy();
            
        } catch (IOException e) {
            System.err.println("Erro ao executar script Python: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Execução interrompida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}