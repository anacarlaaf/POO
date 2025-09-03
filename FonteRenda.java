public class FonteRenda {

    protected enum tipoRecorrencia{
        MENSAL, QUIZENAL, ANUAL, ESPORADICA
    }
    
    private int id;
    private String nome;
    private tipoRecorrencia recorrencia;
}
