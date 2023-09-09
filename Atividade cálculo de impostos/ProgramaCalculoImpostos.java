public class ProgramaCalculoImpostos {

    public static void main(String[] args) {
        // Exemplo de operação comercial
        OperacaoComercial operacao = new OperacaoComercial("Venda de produto", 100.0);

        // Cálculo dos impostos e taxas
        double iss = ISS.calcular(operacao);
        double icms = ICMS.calcular(operacao);
        double ipi = IPI.calcular(operacao);

        // Resultado detalhado
        System.out.println("Descrição da operação: " + operacao.getDescricao());
        System.out.println("Valor original: R$" + operacao.getValor());
        System.out.println("ISS: R$" + iss);
        System.out.println("ICMS: R$" + icms);
        System.out.println("IPI: R$" + ipi);

        double total = operacao.getValor() + iss + icms + ipi;
        System.out.println("Valor total com impostos e taxas: R$" + total);
    }
}
