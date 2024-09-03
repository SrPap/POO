
public class CuentaBancaria {
    private double saldoInicial;

    public CuentaBancaria() {}
    public CuentaBancaria(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }
    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public void retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > saldoInicial) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar el retiro.");
        }
        saldoInicial -= cantidad;
    }
}
