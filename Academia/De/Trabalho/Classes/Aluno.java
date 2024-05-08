package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Aluno {
    private String nome;
    private String cpf;
    private String endereco;
    private String dataNasc;
    private String telefone;

     // Construtor da classe Aluno
    public Aluno(String nome, String cpf, String endereco, String dataNasc, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
    }

    // Getters e setters para as variáveis de instância
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

    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
     // Método para cadastrar um aluno em um arquivo
    public void cadastrarAluno(File arquivo) throws IOException{
        // Verifica se o arquivo não existe e, se não, cria um novo arquivo
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        // Escreve os dados do aluno no arquivo
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.cpf + ";" + this.endereco + ";" + this.dataNasc + ";" + this.telefone, true);
    }

    // Método estático para mostrar os alunos a partir de um arquivo
    public static void mostrarAluno(File arquivo) throws IOException{
        // Lê os dados do arquivo para uma lista
        ArrayList<String> lista = FileManager.lerArquivo(arquivo);
        int posicao =1;

        // Itera sobre cada linha da lista e imprime os detalhes do aluno
        for (String string : lista) {
            String[] partes = string.split(";");
            System.out.println("/-----------------------------------------\\");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("CPF: " + partes[1]);
            System.out.println("Endereço: " + partes[2]);
            System.out.println("Data Nascimento: " + partes[3]);
            System.out.println("Telefone: " + partes[4]);
            System.out.println("\\-----------------------------------------/\n");
            posicao++;
        }
    }

}
