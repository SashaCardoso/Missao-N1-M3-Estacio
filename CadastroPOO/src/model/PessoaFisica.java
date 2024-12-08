package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa {

    private String cpf;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    private int idade;

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);

        this.cpf = cpf;
        this.idade = idade;
    }

    @Override
    public void exibir() {
        System.out.println(
                "Id: " + id
                + "\n"
                + "Nome: " + nome
                + "\n"
                + "CPF: " + cpf
                + "\n"
                + "Idade: " + idade);
    }
}
