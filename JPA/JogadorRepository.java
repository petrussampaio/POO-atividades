package repositorio;

import entidades.Jogador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JogadorRepository {

    private final SessionFactory factory;

    public JogadorRepository() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Jogador.class);
        this.factory = configuration.buildSessionFactory();
    }

    public void inserirJogadores(Jogador... jogadores) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            for (Jogador jogador : jogadores) {
                session.save(jogador);
            }

            session.getTransaction().commit();
        }
    }

    public Jogador buscarJogadorPorId(Long jogadorId) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            return session.get(Jogador.class, jogadorId);
        }
    }

    public void fecharConexao() {
        factory.close();
    }
}
