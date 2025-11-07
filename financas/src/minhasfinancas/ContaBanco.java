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
                List<String> linhas = Files.readAllLines(Paths.get("src/minhasfinancas/openFinance.txt"));

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

    public void gerarExtrato(){
        if (this.transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada.zn");
        } else {
            System.out.println("\n--------- EXTRATO ----------\n");
            Iterator var1 = this.transacoes.iterator();

            while(var1.hasNext()) {
                Transacao var2 = (Transacao)var1.next();
                var2.mostrar();
            }
            System.out.println("-----------------------------\n\n");
        }
    }

    public Map<String, Float> getDespesaPorCategoria() {
        Map<String, Float> mapa = new HashMap<>();
        for (Transacao t : this.transacoes) {
            if (t.getValor() < 0) {
                mapa.put(t.getCategoria(), mapa.getOrDefault(t.getCategoria(), 0f) + Math.abs(t.getValor()));
            }
        }
        return mapa;
    }
}