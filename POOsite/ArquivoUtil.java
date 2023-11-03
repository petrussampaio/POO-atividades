import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    public static void salvarSite(Site site) {
        String nomeArquivo = "dados/" + site.getId() + ".data";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(site);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Site> carregarSites() {
        List<Site> sites = new ArrayList<>();

        File pastaDados = new File("dados/");
        if (!pastaDados.exists()) {
            pastaDados.mkdir();
            return sites;
        }

        File[] arquivos = pastaDados.listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                if (arquivo.isFile() && arquivo.getName().endsWith(".data")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                        Site site = (Site) ois.readObject();
                        sites.add(site);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return sites;
    }
}
