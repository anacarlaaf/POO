import java.time.LocalDate;
import java.util.Scanner;
import minhasfinancas.*;

/**
 * Classe principal do sistema de finanças pessoais.
 *
 * <p>É responsável por inicializar um usuário padrão, criar uma conta bancária
 * associada e exibir um menu interativo que permite o usuário visualizar
 * suas informações, listar contas bancárias cadastradas e acessar o dashboard
 * financeiro gerado pela classe {@link ContaBanco}.</p>
 *
 * <p>O programa permanece em execução até que o usuário selecione a opção
 * de sair.</p>
 */
public class Main {

    /**
     * Método principal que inicia a aplicação de linha de comando.
     *
     * <p>Este método:</p>
     * <ol>
     *   <li>Cria um usuário de exemplo</li>
     *   <li>Cria uma conta bancária e a vincula ao usuário</li>
     *   <li>Mostra um menu com 4 opções:</li>
     *   <ul>
     *       <li>1 – Ver perfil do usuário</li>
     *       <li>2 – Listar contas bancárias do usuário</li>
     *       <li>3 – Gerar e visualizar o dashboard financeiro</li>
     *       <li>4 – Sair do programa</li>
     *   </ul>
     *   <li>Executa continuamente até que o usuário escolha a opção 4</li>
     * </ol>
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args){

        Usuario usuario = new Usuario(
                "Maria",
                LocalDate.of(2000, 6, 15),
                "12345678910",
                "Moderado",
                "maria@email.com"
        );

        ContaBanco banco = new ContaBanco(123, "BR", 1414);
        usuario.vincularContaBanco(banco);

        Scanner sc = new Scanner(System.in);
        Integer op;

        while (true) {

            System.out.println("\n--------- MENU ---------\n");
            System.out.println("1 - Seu perfil\n2 - Listar contas de banco\n3 - Ver Dashboard\n4 - Sair\n");
            System.out.println("------------------------\n");

            try {
                op = sc.nextInt();

                switch (op) {
                    case 1 -> {
                        System.out.println("\n--------- PERFIL ---------\n");
                        usuario.mostrarDados();
                        System.out.println("------------------------\n");
                    }
                    case 2 -> {
                        System.out.println("\n--------- BANCOS ---------\n");
                        usuario.listarContasBanco();
                        System.out.println("------------------------\n");
                    }
                    case 3 -> {
                        System.out.println("\n--------- DASHBOARD ---------\n");
                        if (!usuario.getContasBanco().isEmpty()) {
                            usuario.getContasBanco().get(0).gerarDashboard();
                        }
                        System.out.println("------------------------\n");
                    }
                    case 4 -> {
                        return; // Encerra o programa
                    }
                }

            } catch (Exception e) {
                System.out.println("Erro. Tente novamente.\n");
            }
        }
    }
}
