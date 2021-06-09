package model.conta;

import model.cliente.Cliente;

public abstract class Conta {

    protected final int numero;
    protected double saldo;
    /**
     * Sempre prefira usar BigDecimal para valores que trabalham com dinheiro !*
     */
    protected final Cliente cliente;

    public Conta(int numero, Cliente cliente) {

        this.numero = numero;
        this.cliente = cliente;

    }

    public abstract boolean depositar(double valor);

    public abstract boolean sacar(double valor);

    @Override
    public abstract String toString();

}
