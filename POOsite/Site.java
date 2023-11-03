import java.io.Serializable;

public class Site implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String descricao;
    private String url;
    private String dataCadastro;

    public Site(int id, String descricao, String url, String dataCadastro) {
        this.id = id;
        this.descricao = descricao;
        this.url = url;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nDescrição: " + descricao + "\nURL: " + url + "\nData de Cadastro: " + dataCadastro + "\n";
    }
}
