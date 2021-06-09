package view;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.cliente.Cliente;
import model.conta.GerenciaContas;

public class AppContas {

    private static Cliente cliente;
    private static GerenciaContas gerencia;

    /**
     * Add cliente
     */
    private static void addCliente() {

        Scanner in = new Scanner(System.in);

        System.out.println("Nome: ");
        cliente.setNome(in.nextLine());

        System.out.println("Cpf: ");
        cliente.setCpf(in.nextLine());

    }

    /**
     * Seleciona conta
     *
     * @return
     */
    private static int selecionaConta() {

        Scanner in = new Scanner(System.in);
        System.out.println("Informe o número da conta: ");

        return Integer.valueOf(in.nextLine());

    }

    /**
     * Valor
     *
     * @return
     */
    private static double valor() {

        Scanner in = new Scanner(System.in);
        System.out.println("Valor R$: ");

        return Integer.valueOf(in.nextLine());

    }

    /**
     * Limite
     *
     * @return
     */
    private static double limite() {

        Scanner in = new Scanner(System.in);
        System.out.println("Limite R$: ");

        return Integer.valueOf(in.nextLine());

    }

    /**
     * Taxa poupança
     *
     * @return
     */
    private static double taxaPoupanca() {

        Scanner in = new Scanner(System.in);
        System.out.println("Taxa R$: ");

        return Integer.valueOf(in.nextLine());

    }

    /**
     * Menu de opções
     */
    private static void menu() {

        // menu
        Scanner menu = new Scanner(System.in);

        // opções
        String opcoes = ""
                + "0 - Nova conta corrente"
                + "\n"
                + "1 - Nova conta especial"
                + "\n"
                + "2 - Nova conta poupança"
                + "\n"
                + "3 - Listar contas"
                + "\n"
                + "4 - Remover uma conta"
                + "\n"
                + "5 - Imprimir conta"
                + "\n"
                + "6 - Depositar na corrente"
                + "\n"
                + "7 - Depositar na especial"
                + "\n"
                + "8 - Depositar na poupança"
                + "\n"
                + "9 - Saque na conta corrente"
                + "\n"
                + "10 - Saque na conta especial"
                + "\n"
                + "11 - Saque na conta poupança"
                + "\n"
                + "12 -  Sair"
                + "\n"
                + "";

        // exibe opções
        System.out.println(opcoes);

        // seleciona uma opção
        switch (menu.nextInt()) {

            case 0:
                addCliente();
                gerencia.addConta(0, cliente);
                break;

            case 1:
                addCliente();
                gerencia.addConta(1, cliente);
                break;

            case 2:
                addCliente();
                gerencia.addConta(2, cliente);
                break;

            case 3:
                gerencia.listaContas();
                break;

            case 4:
                gerencia.removeConta(selecionaConta());
                break;

            case 5:
                gerencia.imprime(selecionaConta());
                break;

            case 6:
                gerencia.operacoes(selecionaConta(), valor(), 0, true, 0, 0);
                break;

            case 7:
                gerencia.operacoes(selecionaConta(), valor(), 0, true, 0, 1);
                break;

            case 8:
                gerencia.operacoes(selecionaConta(), valor(), 0, true, 0, 2);
                break;

            case 9:
                gerencia.operacoes(selecionaConta(), valor(), 0, false, 0, 0);
                break;

            case 10:
                gerencia.operacoes(selecionaConta(), valor(), limite(), false, 0, 1);
                break;

            case 11:
                gerencia.operacoes(selecionaConta(), valor(), 0, false, taxaPoupanca(), 2);
                break;

            case 12:
                System.exit(0);

            default:
                System.out.println("Opção não existe!");

        }

        // repete o menu
        while (menu.hasNextLine()) {

            menu();

        }

    }

    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args) {

        try {

            // novo gerencia
            gerencia = new GerenciaContas();

            // cliente
            cliente = new Cliente();

            // menu
            menu();

        } catch (java.lang.NullPointerException | java.lang.NumberFormatException | java.lang.ClassCastException | java.util.InputMismatchException ex) {

            System.out.println("Falha em selecionar opção! Tente novamente");

            menu();

        }

    }

}
