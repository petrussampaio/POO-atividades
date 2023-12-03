import entidades.Jogador;
import excecoes.JogadorNaoEncontradoException;
import repositorio.JogadorRepository;

public class Main {

    public static void main(String[] args) {

        JogadorRepository jogadorRepository = new JogadorRepository();

        inserirJogadores(jogadorRepository);
        imprimirDadosJogadores(jogadorRepository);

        buscarEImprimirJogadorPorId(jogadorRepository, 2); 
        buscarEImprimirJogadorPorId(jogadorRepository, 5); 

        jogadorRepository.fecharConexao();
    }

    private static void inserirJogadores(JogadorRepository jogadorRepository) {
        Jogador jogador1 = new Jogador("Jogador1", "Atirador", "TimeA", "Ouro");
        Jogador jogador2 = new Jogador("Jogador2", "Suporte", "TimeB", "Prata");
        Jogador jogador3 = new Jogador("Jogador3", "Topo", "TimeC", "Diamante");

        jogadorRepository.inserirJogadores(jogador1, jogador2, jogador3);
    }

    private static void imprimirDadosJogadores(JogadorRepository jogadorRepository) {
        var jogadores = jogadorRepository.buscarJogadorPorId(1);

        for (Jogador jogador : jogadores) {
            imprimirDetalhesJogador(jogador);
        }
    }

    private static void buscarEImprimirJogadorPorId(JogadorRepository jogadorRepository, long jogadorId) {
        try {
            Jogador jogador = jogadorRepository.buscarJogadorPorId(jogadorId);

            if (jogador != null) {
                imprimirDetalhesJogador(jogador);
            } else {
                System.out.println("Jogador com ID " + jogadorId + " não encontrado.");
            }
        } catch (JogadorNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void imprimirDetalhesJogador(Jogador jogador) {
        System.out.println("ID: " + jogador.getId());
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Função: " + jogador.getFuncao());
        System.out.println("Time: " + jogador.getNomeTime());
        System.out.println("Patente: " + jogador.getPatente());
        System.out.println();
    }
}
