package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Instrutor {
    private String nome;
    private String cpf;
    private Double salario;
    private String expecialidade;

    public Instrutor(String nome, String cpf, Double salario, String expecialidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.expecialidade = expecialidade;
    }

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

    public String getExpecialidade() {
        return expecialidade;
    }public void setExpecialidade(String expecialidade) {
        this.expecialidade = expecialidade;
    }
    
    public Double getSalario() {
        return salario;
    }

    public void cadastrarInstrutor(File arquivo) throws IOException{
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.cpf + ";" + this.salario + ";" + this.expecialidade + ";", true);
    }

    public static void mostrarInstrutor(File arquivo) throws IOException{
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        int posicao =1;

        for (String string : resultado) {
            String[] partes = string.split(";");
            System.out.println("=========================================");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("CPF: " + partes[1]);
            System.out.println("Salario: " + partes[2]);
            System.out.println("Expecialidade: " + partes[3]);
            System.out.println("=========================================");
            posicao++;
        }
    }
    
}
