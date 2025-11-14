import java.time.LocalDate;
import java.util.Scanner;
import minhasfinancas.*;

public class Main {
    
    public static void main(String[] args){

        Usuario usuario = new Usuario("Maria", LocalDate.of(2000, 6, 15), "12345678910", "Moderado", "maria@email.com");
        ContaBanco banco = new ContaBanco(123, "BR", 1414);
        usuario.vincularContaBanco(banco);
    
        Scanner sc = new Scanner(System.in);
        Integer op;
        while(true){

            System.out.println("\n--------- MENU ---------\n");
            System.out.println("1 - Seu perfil\n2 - Listar contas de banco\n3 - Ver Dashboard\n4 - Sair\n");
            System.out.println("------------------------\n");

            try {
                op = sc.nextInt();
                switch (op){
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
                        if(!usuario.getContasBanco().isEmpty()){
                            usuario.getContasBanco().get(0).gerarDashboard(); // Gera Dashboard
                        }
                        System.out.println("------------------------\n");
                    }
                    case 4 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro. Tente novamente.\n");
            }
        }
        
    }
}