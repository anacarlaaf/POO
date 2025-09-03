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