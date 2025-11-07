import minhasfinancas.*;

public class Main {

    public static void main(String[] args){
        Usuario usuario = new Usuario();
        usuario.cadastrarUsuario();

        usuario.mostrarDados();

        ContaBanco banco = new ContaBanco(0, "BB", 1);
        usuario.vincularContaBanco(banco);
        ContaBanco banco2 = new ContaBanco(0, "BR", 1);
        usuario.vincularContaBanco(banco2);

        usuario.listarContasBanco();

        if(!usuario.getContasBanco().isEmpty()){
            usuario.getContasBanco().get(0).sincronizar();  // Simula requisição em API (Open Finance)
            usuario.getContasBanco().get(0).gerarExtrato();
        }
    }
}