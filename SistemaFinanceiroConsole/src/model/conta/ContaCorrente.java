package model.conta;

import model.cliente.Cliente;

public class ContaCorrente extends Conta {

    /**
     * Construtor
     *
     * @param numero Número da conta
     * @param cliente
     */
    public ContaCorrente(int numero, Cliente cliente) {

        // chama o construtor pai
        super(numero, cliente);

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
                + "Conta corrente"
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
