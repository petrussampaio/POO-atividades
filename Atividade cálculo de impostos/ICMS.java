public class ICMS {
    private static final double ALIQUOTA = 0.17;

    public static double calcular(OperacaoComercial operacao) {
        if (operacao.getDescricao().toLowerCase().contains("produto") || operacao.getDescricao().toLowerCase().contains("serviço")) {
            return operacao.getValor() * ALIQUOTA;
        } else {
            return 0;
        }
    }
}
