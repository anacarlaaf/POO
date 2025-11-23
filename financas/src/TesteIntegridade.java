import java.lang.reflect.*;

public class TesteIntegridade {

    public static void main(String[] args) {
        testarClasse("minhasfinancas.Usuario",
                new String[]{"mostrarDados", "listarContasBanco"},
                new Class<?>[][]{}
        );

        testarClasse("minhasfinancas.Conta",
                new String[]{"getNumero", "getAgencia", "getPais"},
                new Class<?>[][]{}
        );

        testarClasse("minhasfinancas.ContaBanco",
                new String[]{"gerarDashboard"},
                new Class<?>[][]{}
        );

        testarClasse("minhasfinancas.Transacao",
                new String[]{"mostrarTransacao"},
                new Class<?>[][]{}
        );

        testarClasse("minhasfinancas.Investimento",
                new String[]{"mostrarInvestimento"},
                new Class<?>[][]{}
        );
    }

    private static void testarClasse(String nomeClasse, String[] metodosObrigatorios, Class<?>[][] assinaturas) {
        System.out.println("\nTestando: " + nomeClasse);

        try {
            Class<?> c = Class.forName(nomeClasse);

            // ----------- VERIFICA CLASSE EXISTE -----------
            if (c == null) {
                falhar("Classe não encontrada: " + nomeClasse);
                return;
            }

            // ----------- VERIFICA ATRIBUTOS (HERANÇA INCLUÍDA) -----------
            Field[] declarados = c.getDeclaredFields();
            Field[] herdados = c.getFields(); // públicos herdados

            if (declarados.length == 0 && herdados.length == 0) {
                System.out.println(" ⚠ Aviso: classe não possui atributos próprios (pode ser normal se herdar de outra).");
            } else {
                System.out.println(" ✓ Atributos detectados.");
            }

            // ----------- VERIFICA MÉTODOS OBRIGATÓRIOS -----------
            for (String metodo : metodosObrigatorios) {
                boolean existe = false;

                for (Method m : c.getDeclaredMethods()) {
                    if (m.getName().equals(metodo)) {
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    falhar("Método obrigatório ausente: " + metodo);
                    return;
                }
            }

            System.out.println(" OK — classe válida.");

        } catch (Exception e) {
            falhar("Erro ao carregar classe: " + e.getMessage());
        }
    }

    private static void falhar(String msg) {
        System.out.println("\n=====================================");
        System.out.println("✖ FALHA NO TESTE DE INTEGRIDADE");
        System.out.println("Motivo: " + msg);
        System.out.println("=====================================");
    }
}
