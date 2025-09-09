import java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        Usuario usuario = new Usuario(0, "Teste", LocalDate.parse("1999-11-30"), "XXXXXXXXXXX", "Moderado", "teste@teste.com");
        ContaBanco banco = new ContaBanco(0, "Banco XX", 1, "XX");
        usuario.vincularContaBanco(banco);

        ContaBanco banco2 = new ContaBanco(0, "Banco XY", 1, "XX");
        usuario.vincularContaBanco(banco2);

        usuario.listarContasBanco();
    }
}