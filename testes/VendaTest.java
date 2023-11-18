import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class VendaTest {

    @Test
    public void testCalcularValorTotalVenda() {
        List<ItemVenda> itens = new ArrayList<>();
        itens.add(new ItemVenda("Produto1", 20.0, 2.0));
        itens.add(new ItemVenda("Produto2", 30.0, 1.0));
        Venda venda = new Venda("Cliente1", itens, 0.0, 0.0);

        assertEquals(70.0, venda.calcularValorTotalVenda());
    }

    @Test
    public void testCalcularValorComDesconto() {
        List<ItemVenda> itens = new ArrayList<>();
        itens.add(new ItemVenda("Produto1", 20.0, 2.0));
        itens.add(new ItemVenda("Produto2", 30.0, 1.0));
        Venda venda = new Venda("Cliente1", itens, 70.0, 10.0);

        assertEquals(60.0, venda.calcularValorComDesconto());
    }

    @Test
    public void testObterListaItens() {
        List<ItemVenda> itens = new ArrayList<>();
        itens.add(new ItemVenda("Produto1", 20.0, 2.0));
        itens.add(new ItemVenda("Produto2", 30.0, 1.0));
        Venda venda = new Venda("Cliente1", itens, 70.0, 10.0);

        assertEquals(itens, venda.getItens());
    }
}
