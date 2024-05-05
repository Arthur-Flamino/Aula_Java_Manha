package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Aluno {
    private String nome;
    private String cpf;
    private String endereco;
    private Date dataNasc;
    private String telefone;

    public Aluno(String nome, String cpf, String endereco, Date dataNasc, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
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
    
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void cadastrarAluno(File arquivo) throws IOException{
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.cpf + ";" + this.endereco + ";" + this.dataNasc + ";" + this.telefone, true);
    }

    public static void mostrarAluno(File arquivo) throws IOException{
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        int posicao =1;

        for (String string : resultado) {
            String[] partes = string.split(";");
            System.out.println("=========================================");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("CPF: " + partes[1]);
            System.out.println("Endereço: " + partes[2]);
            System.out.println("Data Nascimento: " + partes[3]);
            System.out.println("Telefone: " + partes[4]);
            System.out.println("=========================================");
            posicao++;
        }
    }

}
