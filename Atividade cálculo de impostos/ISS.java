public class ISS {
    private static final double ALIQUOTA = 0.046;

    public static double calcular(OperacaoComercial operacao) {
        if (operacao.getDescricao().toLowerCase().contains("serviço")) {
            return operacao.getValor() * ALIQUOTA;
        } else {
            return 0;
        }
    }
}
