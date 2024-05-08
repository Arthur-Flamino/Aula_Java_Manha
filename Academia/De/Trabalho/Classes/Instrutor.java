package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Instrutor {
    private String nome;
    private String cpf;
    private Double salario;
    private String expecialidade;

    // Construtor da classe Instrutor
    public Instrutor(String nome, String cpf, Double salario, String expecialidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.expecialidade = expecialidade;
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

    public String getExpecialidade() {
        return expecialidade;
    }public void setExpecialidade(String expecialidade) {
        this.expecialidade = expecialidade;
    }
    
    public Double getSalario() {
        return salario;
    }

    // Método para cadastrar um instrutor em um arquivo
    public void cadastrarInstrutor(File arquivo) throws IOException{
        // Verifica se o arquivo não existe e, se não, cria um novo arquivo
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        // Escreve os dados do intrutor no arquivo
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.cpf + ";" + this.salario + ";" + this.expecialidade + ";", true);
    }

    // Método estático para mostrar os intrutor a partir de um arquivo
    public static void mostrarInstrutor(File arquivo) throws IOException{
        // Lê os dados do arquivo para uma lista
        ArrayList<String> lista = FileManager.lerArquivo(arquivo);
        int posicao =1;

        // Itera sobre cada linha da lista e imprime os detalhes do instrutor
        for (String string : lista) {
            String[] partes = string.split(";");
            System.out.println("/-----------------------------------------\\");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("CPF: " + partes[1]);
            System.out.println("Salario: " + partes[2]);
            System.out.println("Expecialidade: " + partes[3]);
            System.out.println("\\-----------------------------------------/\n");
            posicao++;
        }
    }
    
}
