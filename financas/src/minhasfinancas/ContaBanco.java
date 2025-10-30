package minhasfinancas;
import java.time.LocalDate;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ContaBanco extends Conta<Transacao>{

    public ContaBanco(int codigo, String nome, int numeroConta, String tokenAcesso) {
        super(codigo, nome, numeroConta, tokenAcesso); // Chama o construtor da classe pai
    }

    public void sincronizar(){ // Temporário (será implementado na classe abstrata pai)

        int id;
        float valor;
        LocalDate data;
        String descricao;
        boolean tipo;
        String origem;

        try {
                List<String> linhas = Files.readAllLines(Paths.get("src/minhasfinancas/openFinance.txt"));

                for (String linha : linhas) {
                if (linha.trim().isEmpty()) continue; // pular linhas vazias

                String[] partes = linha.split(";", -1); // -1 mantém campos vazios

                id = Integer.parseInt(partes[0]);
                valor = Float.parseFloat(partes[1]);
                data = LocalDate.parse(partes[2]);
                descricao = partes[3];
                tipo = Boolean.parseBoolean(partes[4]);
                origem = partes[5];
                
                Transacao t = new Transacao(id, valor, data, descricao, tipo, origem);
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
        }
    }
}