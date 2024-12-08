package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> arrayFisica;

    public PessoaFisicaRepo() {
        arrayFisica = new ArrayList<PessoaFisica>();
    }

    public void inserir(PessoaFisica p) {
        arrayFisica.add(p);
    }

    public void alterar(PessoaFisica pessoa) {
        int i = 0;
        for (PessoaFisica p : arrayFisica) {
            if (p.id == pessoa.id) {
                arrayFisica.set(i, pessoa);
            }
            i++;
        }
    }

    public void excluir(int id) {
        PessoaFisica temp = null;
        for (PessoaFisica p : arrayFisica) {
            if (p.id == id) {
                temp = p;
            }
        }
        arrayFisica.remove(temp);
    }

    public PessoaFisica obter(int id) throws Exception {
        for (PessoaFisica p : arrayFisica) {
            if (p.id == id) {
                return p;
            }
        }
        throw new Exception("Person not found");
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return arrayFisica;
    }

    public void persistir(String filepath) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filepath));
        output.writeObject(arrayFisica);
        output.close();
        System.out.println("Dados de Pessoa Fisica Armazenados.");
    }

    public void recuperar(String filepath) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filepath));
        arrayFisica = (ArrayList<PessoaFisica>) input.readObject();
        input.close();
        System.out.println("Dados de Pessoa Fisica Recuperados.");
    }
}
