package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> arrayJuridica;

    public PessoaJuridicaRepo() {
        arrayJuridica = new ArrayList<PessoaJuridica>();
    }

    public void inserir(PessoaJuridica p) {
        arrayJuridica.add(p);
    }

    public void alterar(PessoaJuridica pessoa) {
        int i = 0;
        for (PessoaJuridica p : arrayJuridica) {
            if (p.id == pessoa.id) {
                arrayJuridica.set(i, pessoa);
            }
            i++;
        }
    }

    public void excluir(int id) {
        PessoaJuridica temp = null;
        for (PessoaJuridica p : arrayJuridica) {
            if (p.id == id) {
                temp = p;
            }
        }
        arrayJuridica.remove(temp);
    }

    public PessoaJuridica obter(int id) throws Exception {
        for (PessoaJuridica p : arrayJuridica) {
            if (p.id == id) {
                return p;
            }
        }
        throw new Exception("Person not found");
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return arrayJuridica;
    }

    public void persistir(String filepath) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filepath));
        output.writeObject(arrayJuridica);
        output.close();
        System.out.println("Dados de Pessoa Juridica Armazenados.");
    }

    public void recuperar(String filepath) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filepath));
        arrayJuridica = (ArrayList<PessoaJuridica>) input.readObject();
        input.close();
        System.out.println("Dados de Pessoa Juridica Recuperados.");
    }
}
