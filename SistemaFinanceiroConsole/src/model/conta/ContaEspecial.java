package model.conta;

import model.cliente.Cliente;

public class ContaEspecial extends Conta {

    private double limite;

    /**
     * Construtor
     *
     * @param numero Número da conta
     * @param cliente
     */
    public ContaEspecial(int numero, Cliente cliente) {

        // chama o construtor pai
        super(numero, cliente);

    }

    /**
     * Seta o limite
     *
     * @param limite
     */
    public void setLimite(double limite) {

        this.limite = limite;

    }

    /**
     * Retorna o limite
     *
     * @return
     */
    public double getLimite() {

        return limite;

    }

    @Override
    public boolean depositar(double valor) {

        // o valor a ser depositado tem que ser maior do que zero
        if (valor > 0) {

            // atualiza o saldo
            this.saldo += valor;

            // ok
            return true;

        } else {

            // deu erro
            return false;

        }

    }

    @Override
    public boolean sacar(double valor) {

        // saldo + limite
        double saldoTotal = (this.saldo + this.limite);

        // o saldo deve ser maior ou igual o valor, e o valor maior do que zero
        if (saldoTotal >= valor && valor > 0) {

            // atualiza saldo
            this.saldo -= valor;

            // ok
            return true;

        } else {

            // deu erro
            return false;

        }

    }

    @Override
    public String toString() {

        String retorno = ""
                + "Conta especial"
                + "\n"
                + cliente.toString()
                + "\n"
                + "Saldo R$: " + this.saldo
                + "\n"
                + "Número da conta: " + this.numero
                + "";

        return retorno;

    }

}
