import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario usuario = new Usuario(0, "Ana Carla", LocalDate.parse("2002-11-30"), "asdsadsa", "sadsdas", "asdasdsa");
        System.out.println(usuario.getCPF());
        usuario.mostrarDados();
        System.out.println(usuario.calcularIdade());
    }
}
