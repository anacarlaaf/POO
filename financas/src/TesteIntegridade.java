import java.lang.reflect.*;

public class TesteIntegridade {

    public static void main(String[] args) {

        try {
            testarClasse("minhasfinancas.Usuario");
            testarClasse("minhasfinancas.Conta");
            testarClasse("minhasfinancas.ContaBanco");
            testarClasse("minhasfinancas.ContaCorretora");
            testarClasse("minhasfinancas.Investimento");
            testarClasse("minhasfinancas.Transacao");

            System.out.println("\n=====================================");
            System.out.println("✔ TODOS OS TESTES PASSARAM!");
            System.out.println("=====================================");

        } catch (Exception e) {
            System.out.println("\n=====================================");
            System.out.println("✖ FALHA NO TESTE DE INTEGRIDADE");
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("=====================================");
        }
    }

    private static void testarClasse(String nomeClasse) throws Exception {
        System.out.println("\nTestando: " + nomeClasse);

        Class<?> c;
        try {
            c = Class.forName(nomeClasse);
        } catch (ClassNotFoundException e) {
            throw new Exception("Classe não encontrada: " + nomeClasse);
        }

        // Testa se a classe tem pelo menos um atributo
        Field[] atributos = c.getDeclaredFields();
        if (atributos.length == 0) {
            throw new Exception("A classe " + nomeClasse + " não possui atributos. Estrutura incorreta.");
        }

        // Testa se possui construtor público
        Constructor<?>[] construtores = c.getConstructors();
        if (construtores.length == 0) {
            throw new Exception("A classe " + nomeClasse + " não possui construtor público.");
        }

        // Testa se possui pelo menos um método
        Method[] metodos = c.getDeclaredMethods();
        if (metodos.length == 0) {
            throw new Exception("A classe " + nomeClasse + " não possui métodos.");
        }

        System.out.println(" OK — classe válida.");
    }
}
