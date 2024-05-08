package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Exercicio {
    private String nome;
    private Equipamento equipamento;

    // Construtor da classe Exercicio
    public Exercicio(String nome, Equipamento equipamento) {
        this.nome = nome;
        this.equipamento = equipamento;
    }

    // Getters e setters para as variáveis de instância
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

     // Método para cadastrar um exercicio em um arquivo
    public void cadastrarExercicio(File arquivo) throws IOException{
        // Verifica se o arquivo não existe e, se não, cria um novo arquivo
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        // Escreve os dados do exercicio no arquivo
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.equipamento.getNome() + ";", true);
    }

    // Método estático para mostrar os exericios a partir de um arquivo
    public static void mostrarExercicio(File arquivo) throws IOException{
         // Lê os dados do arquivo para uma lista
        ArrayList<String> lista = FileManager.lerArquivo(arquivo);
        int posicao =1;

         // Itera sobre cada linha da lista e imprime os detalhes do exercicio
        for (String string : lista) {
            String[] partes = string.split(";");
            System.out.println("/-----------------------------------------\\");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("Equipamento utilizado: " + partes[1]);
            System.out.println("\\-----------------------------------------/\n");
            posicao++;
        }
    }
    
}