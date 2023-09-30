public class UF implements Estruturador {
    private String nome;
    private String sigla;
    private String capital;
    // Adicione mais atributos conforme necessário

    public UF(String nome, String sigla, String capital) {
        this.nome = nome;
        this.sigla = sigla;
        this.capital = capital;
        // Inicialize outros atributos conforme necessário
    }

    @Override
    public String estruturar() {
        // Implemente aqui a lógica de estruturação em XML, JSON ou YAML para UF
        return "UF: " + nome + ", Sigla: " + sigla;
    }
}
