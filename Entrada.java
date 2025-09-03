class Entrada extends Transacao{

    private enum tipoEntrada{
        SALARIO, RENDA_EXTRA, INVESTIMENTO, PASSIVA
    }

    private tipoEntrada entrada;
    private FonteRenda origem;
}