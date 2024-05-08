package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Equipamento {
    private String nome;
    private String funcao_equipamento;
    
     // Construtor da classe Equipamento vazio
    public Equipamento(String string) {
    
    }

     // Construtor da classe Equipamento com this
    public Equipamento(String nome, String funcao_equipamento) {
        this.nome = nome;
        this.funcao_equipamento = funcao_equipamento;
    }

    // Getters e setters para as variáveis de instância
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao_equipamento() {
        return funcao_equipamento;
    }
    public void setFuncao_equipamento(String funcao_equipamento) {
        this.funcao_equipamento = funcao_equipamento;
    }

     // Método para cadastrar um aluno em um arquivo
    public void cadastrarEquipamento(File arquivo) throws IOException{
         // Verifica se o arquivo não existe e, se não, cria um novo arquivo
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        // Escreve os dados do equipamento no arquivo
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.funcao_equipamento + ";", true);
    }

    // Método estático para mostrar os equipamento a partir de um arquivo
    public static void mostrarEquipamento(File arquivo) throws IOException{
        // Lê os dados do arquivo para uma lista
        ArrayList<String> lista = FileManager.lerArquivo(arquivo);
        int posicao =1;

        // Itera sobre cada linha da lista e imprime os detalhes do equipamento
        for (String string : lista) {
            String[] partes = string.split(";");
            System.out.println("/-----------------------------------------\\");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("Função do equipamento: " + partes[1]);
            System.out.println("\\-----------------------------------------/\n");
            posicao++;
        }
    }

}
