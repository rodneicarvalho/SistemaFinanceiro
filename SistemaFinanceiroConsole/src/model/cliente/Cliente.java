package model.cliente;

public class Cliente {

    private String nome;
    private String cpf;

    public String getNome() {

        return nome;

    }

    public void setNome(String nome) {

        this.nome = nome;

    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;

    }

    @Override
    public String toString() {

        String retorno = ""
                + "Cliente: " + this.getNome()
                + "\n"
                + "Cliente: " + this.getCpf()
                + "";

        return retorno;

    }

}
