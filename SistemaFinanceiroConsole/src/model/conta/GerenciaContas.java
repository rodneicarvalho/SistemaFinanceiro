package model.conta;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Objects.isNull;
import model.cliente.Cliente;

public class GerenciaContas {

    private static Map contas;
    private static int numeroConta;

    /**
     * Construtor
     */
    public GerenciaContas() {

        if (isNull(contas)) {

            contas = new LinkedHashMap();

        }

    }

    /**
     * Add conta
     *
     * @param tipo
     * @param cliente
     */
    public void addConta(int tipo, Cliente cliente) {

        // atualiza numero de conta
        numeroConta++;

        // seleciona o tipo de conta
        switch (tipo) {

            case 0:
                contas.put(numeroConta, new ContaCorrente(numeroConta, cliente));
                break;

            case 1:
                contas.put(numeroConta, new ContaEspecial(numeroConta, cliente));
                break;

            case 2:
                contas.put(numeroConta, new ContaPoupanca(numeroConta, cliente));
                break;

        }

    }

    /**
     * Remove conta
     *
     * @param numeroConta
     */
    public void removeConta(int numeroConta) {

        // remove a conta
        contas.remove(numeroConta);

        // recarrega
        this.listaContas();

    }

    /**
     * Lista contas
     *
     */
    public void listaContas() {

        // iterador
        Iterator iterador = contas.entrySet().iterator();

        // itera
        while (iterador.hasNext()) {

            // dados
            Map.Entry dados = (Map.Entry) iterador.next();

            // conta
            Conta conta = (Conta) dados.getValue();

            // imprime conta
            System.out.println("\n---------------------------------------------------");
            System.out.println(conta.toString());
            System.out.println("---------------------------------------------------\n");

        }

    }

    /**
     * Imprime conta
     *
     * @param numeroConta
     */
    public void imprime(int numeroConta) {

        System.out.println("\n---------------------------------------------------");
        System.out.println(contas.get(numeroConta).toString());
        System.out.println("---------------------------------------------------\n");

    }

    /**
     * Operações nas contas
     *
     * @param numeroConta
     * @param valor
     * @param limite
     * @param modoDepositar
     * @param taxaSaquePoupanca
     * @param tipoSelecionado
     */
    public void operacoes(int numeroConta, double valor, double limite, boolean modoDepositar, double taxaSaquePoupanca, int tipoSelecionado) {

        // corrente
        if (tipoSelecionado == 0) {

            // conta
            ContaCorrente conta = (ContaCorrente) contas.get(numeroConta);

            if (modoDepositar) {

                conta.depositar(valor);

            } else {

                conta.sacar(valor);

            }

        }

        // especial
        if (tipoSelecionado == 1) {

            // conta
            ContaEspecial conta = (ContaEspecial) contas.get(numeroConta);
            conta.setLimite(limite);

            if (modoDepositar) {

                conta.depositar(valor);

            } else {

                conta.sacar(valor);

            }

        }

        // poupança
        if (tipoSelecionado == 2) {

            // conta
            ContaPoupanca conta = (ContaPoupanca) contas.get(numeroConta);

            if (modoDepositar) {

                conta.depositar(valor);

            } else {

                conta.setTaxa(taxaSaquePoupanca);
                conta.sacar(valor);

            }

        }

    }

}
