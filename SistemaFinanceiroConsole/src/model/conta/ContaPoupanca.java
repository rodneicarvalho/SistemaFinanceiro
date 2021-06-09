package model.conta;

import model.cliente.Cliente;

public class ContaPoupanca extends Conta {

    private static double taxa;

    /**
     * Construtor
     *
     * @param numero Número da conta
     * @param cliente
     */
    public ContaPoupanca(int numero, Cliente cliente) {

        // chama o construtor pai
        super(numero, cliente);

    }

    public double getTaxa() {

        return taxa;

    }

    public void setTaxa(double taxa) {

        ContaPoupanca.taxa = taxa;

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

        // o saldo deve ser maior ou igual o valor, e o valor maior do que zero
        if (this.saldo >= valor && valor > 0) {

            // atualiza saldo
            this.saldo -= (valor + ContaPoupanca.taxa);

            // não existe saldo negativo em poupança
            if (this.saldo < 0) {

                this.saldo = 0;

            }

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
                + "Conta poupança"
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
