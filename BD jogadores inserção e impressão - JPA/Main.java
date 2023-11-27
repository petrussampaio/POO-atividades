import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Jogador.class);
        SessionFactory factory = configuration.buildSessionFactory();
      
        
        inserirJogadores(factory);

        
        imprimirDadosJogadores(factory);

      
        factory.close();
    }

    private static void inserirJogadores(SessionFactory factory) {
        try (Session session = factory.openSession()) {
          
            session.beginTransaction();

            
            Jogador jogador1 = new Jogador("Jogador1", "Atirador", "TimeA", "Ouro");
            Jogador jogador2 = new Jogador("Jogador2", "Suporte", "TimeB", "Prata");
            Jogador jogador3 = new Jogador("Jogador3", "Topo", "TimeC", "Diamante");

            session.save(jogador1);
            session.save(jogador2);
            session.save(jogador3);

            
            session.getTransaction().commit();
        }
    }

    private static void imprimirDadosJogadores(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            
            session.beginTransaction();
            var jogadores = session.createQuery("FROM Jogador", Jogador.class).getResultList();

            
            for (Jogador jogador : jogadores) {
                System.out.println("ID: " + jogador.getId());
                System.out.println("Nome: " + jogador.getNome());
                System.out.println("Função: " + jogador.getFuncao());
                System.out.println("Time: " + jogador.getNomeTime());
                System.out.println("Patente: " + jogador.getPatente());
                System.out.println();
            }

            
            session.getTransaction().commit();
        }
    }
}
