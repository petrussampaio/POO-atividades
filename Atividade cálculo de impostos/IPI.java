public class IPI {
    private static final double ALIQUOTA = 0.25;

    public static double calcular(OperacaoComercial operacao) {
        if (operacao.getDescricao().toLowerCase().contains("produto")) {
            return operacao.getValor() * ALIQUOTA;
        } else {
            return 0;
        }
    }
}
