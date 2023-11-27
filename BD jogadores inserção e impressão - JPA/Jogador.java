import javax.persistence.*;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String funcao;
    private String nomeTime;
    private String patente;


    public Jogador(String nome, String funcao, String nomeTime, String patente) {
        this.nome = nome;
        this.funcao = funcao;
        this.nomeTime = nomeTime;
        this.patente = patente;
    }
}
