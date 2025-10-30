import java.time.LocalDate;

import minhasfinancas.*;

public class Main {

    public static void main(String[] args){
        Usuario usuario = new Usuario(0, "Teste", LocalDate.parse("1999-11-30"), "XXXXXXXXXXX", "Moderado", "teste@teste.com");

        usuario.mostrarDados();

        ContaBanco banco = new ContaBanco(0, "BB", 1, "XX");
        usuario.vincularContaBanco(banco);
        ContaBanco banco2 = new ContaBanco(0, "BR", 1, "XX");
        usuario.vincularContaBanco(banco2);

        usuario.listarContasBanco();

        if(!usuario.getContasBanco().isEmpty()){
            usuario.getContasBanco().get(0).sincronizar();  // simular requisição em API (Open Finance)
            usuario.getContasBanco().get(0).gerarExtrato();
        } 

    }
}