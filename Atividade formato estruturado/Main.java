import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


public class Main {
    public static void main(String[] args) {
        // Gere automaticamente conteúdo para fins de teste
        VeiculoEletrico veiculo = new VeiculoEletrico("Modelo1", "Marca1", 300, 120, 50000.0);
        UF uf = new UF("Estado1", "ES1", "Capital1");

        // Solicite ao usuário escolher o formato
        String formato = "XML"; // Substitua pela lógica de entrada do usuário

        // Exiba o resultado no formato selecionado
        switch (formato.toUpperCase()) {
            case "XML":
                System.out.println(veiculo.estruturar());
                System.out.println(uf.estruturar());
                break;
            case "JSON":
                System.out.println(convertToJSON(veiculo));
                System.out.println(convertToJSON(uf));
                break;
            case "YAML":
                System.out.println(convertToYAML(veiculo));
                System.out.println(convertToYAML(uf));
                break;
            default:
                System.out.println("Formato inválido.");
        }
    }

    private static String convertToJSON(Estruturador estruturador) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(estruturador);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String convertToYAML(Estruturador estruturador) {
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            return yamlMapper.writeValueAsString(estruturador);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
