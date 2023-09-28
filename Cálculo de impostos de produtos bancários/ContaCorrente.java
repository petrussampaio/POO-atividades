
public class ContaCorrente extends Conta implements Tributavel {
    public ContaCorrente(double saldo) {
        super(saldo);
    }

    public double calculaTributos() {
        return saldo * 0.01;
    }
}
