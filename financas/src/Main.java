import java.time.LocalDate;
import minhasfinancas.*;

public class Main {

    public static void main(String[] args){
        Usuario usuario = new Usuario("Maria", LocalDate.of(2000, 6, 15), "12345678910", "Moderado", "maria@email.com");
        ContaBanco banco = new ContaBanco(123, "BR", 1414);
        
        usuario.mostrarDados();
        usuario.vincularContaBanco(banco);
        usuario.listarContasBanco();

        if(!usuario.getContasBanco().isEmpty()){
            usuario.getContasBanco().get(0).gerarDashboard(); // Gera Dashboard
        }
    }
}