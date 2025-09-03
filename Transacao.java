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

class Entrada extends Transacao{

    private enum tipoEntrada{
        SALARIO, RENDA_EXTRA, INVESTIMENTO, PASSIVA
    }

    private tipoEntrada entrada;
    private FonteRenda origem;
}

class Gasto extends Transacao{

    private enum categoriaGasto{
        ALIMENTACAO, SAUDE, MORADIA, LAZER, EDUCACAO, TRANSPORTE
    }

    private enum categoriaPagamento{
        CREDITO, DEBITO, PIX, DINHEIRO
    }

    private categoriaGasto categoria;
    private String origem;
    private  categoriaPagamento formaPagamento;
}

class FonteRenda {

    protected enum tipoRecorrencia{
        MENSAL, QUIZENAL, ANUAL, ESPORADICA
    }
    
    private int id;
    private String nome;
    private tipoRecorrencia recorrencia;
}
