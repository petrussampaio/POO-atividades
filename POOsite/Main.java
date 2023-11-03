import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Site> sites = ArquivoUtil.carregarSites();

        while (true) {
            System.out.println("1. Adicionar Site");
            System.out.println("2. Listar Sites");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarSite(sites);
                    break;
                case 2:
                    listarSites(sites);
                    break;
                case 3:
                    salvarSites(sites);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarSite(List<Site> sites) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("URL: ");
        String url = scanner.nextLine();

        String dataCadastro = java.time.LocalDate.now().toString();

        int id = sites.size() + 1;
        Site site = new Site(id, descricao, url, dataCadastro);
        sites.add(site);

        ArquivoUtil.salvarSite(site);
        System.out.println("Site adicionado com sucesso!");
    }

    private static void listarSites(List<Site> sites) {
        if (sites.isEmpty()) {
            System.out.println("Nenhum site cadastrado.");
        } else {
            for (Site site : sites) {
                System.out.println(site);
            }
        }
    }

    private static void salvarSites(List<Site> sites) {
        for (Site site : sites) {
            ArquivoUtil.salvarSite(site);
        }
    }
}
