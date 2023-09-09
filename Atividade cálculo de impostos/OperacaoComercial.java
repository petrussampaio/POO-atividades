public class OperacaoComercial {
    private String descricao;
    private double valor;

    public OperacaoComercial(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
