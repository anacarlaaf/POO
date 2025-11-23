import java.lang.reflect.*;

public class TesteIntegridade {

    public static void main(String[] args) {
        testarClasse("minhasfinancas.Usuario", new String[]{"nomeCompleto", "cpf", "dataNascimento", "perfil", "email"}, new String[]{});
        testarClasse("minhasfinancas.Conta", new String[]{"codigo", "nome", "numeroConta"}, new String[]{});
        testarClasse("minhasfinancas.ContaBanco", new String[]{}, new String[]{});
        testarClasse("minhasfinancas.Transacao", new String[]{"valor", "data", "descricao"}, new String[]{"mostrar"});
        testarClasse("minhasfinancas.ContaCorretora", new String[]{}, new String[]{});
    }

    private static void testarClasse(String nomeClasse, String[] atributosObrigatorios, String[] metodosObrigatorios) {
        System.out.println("\nTestando: " + nomeClasse);

        try {
            Class<?> cls = Class.forName(nomeClasse);

            boolean temAtributos = false;
            Field[] atributos = cls.getDeclaredFields();
            if (atributos.length > 0) temAtributos = true;

            if (temAtributos) {
                System.out.println(" ✓ Atributos detectados.");
            } else {
                System.out.println(" ⚠ Aviso: classe não possui atributos próprios (pode ser normal se herdar de outra).");
            }

            for (String atributo : atributosObrigatorios) {
                try {
                    cls.getDeclaredField(atributo);
                } catch (NoSuchFieldException e) {
                    falha("Atributo obrigatório ausente: " + atributo);
                    return;
                }
            }

            for (String metodo : metodosObrigatorios) {
                try {
                    cls.getDeclaredMethod(metodo);
                } catch (NoSuchMethodException e) {
                    falha("Método obrigatório ausente: " + metodo);
                    return;
                }
            }

            System.out.println(" OK — classe válida.");

        } catch (ClassNotFoundException e) {
            falha("Classe não encontrada: " + nomeClasse);
        }
    }

    private static void falha(String motivo) {
        System.out.println("\n=====================================");
        System.out.println("✖ FALHA NO TESTE DE INTEGRIDADE");
        System.out.println("Motivo: " + motivo);
        System.out.println("=====================================");
    }
}

