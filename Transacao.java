import java.util.Date;

abstract class Transacao{

    protected enum tipoRecorrencia{
        MENSAL, QUIZENAL, ANUAL, ESPORADICA
    }

    protected int id;
    protected float valor;
    protected Date data;
    protected String descricao;
}