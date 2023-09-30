public class VeiculoEletrico implements Estruturador {
    private String modelo;
    private String marca;
    private int autonomia;
    private int velocidadeMaxima;
    private double precoSugerido;

    public VeiculoEletrico(String modelo, String marca, int autonomia, int velocidadeMaxima, double precoSugerido) {
        this.modelo = modelo;
        this.marca = marca;
        this.autonomia = autonomia;
        this.velocidadeMaxima = velocidadeMaxima;
        this.precoSugerido = precoSugerido;
    }

    @Override
    public String estruturar() {
        // Implemente aqui a lógica de estruturação em XML, JSON ou YAML para Veículo Elétrico
        return "Veículo Elétrico: " + modelo + ", Marca: " + marca;
    }
}
