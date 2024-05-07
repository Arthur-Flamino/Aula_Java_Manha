package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Exercicio {
    private String nome;
    private Equipamento equipamento;


    public Exercicio(String nome, Equipamento equipamento) {
        this.nome = nome;
        this.equipamento = equipamento;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public void cadastrarExercicio(File arquivo) throws IOException{
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.equipamento + ";", true);
    }

    public static void mostrarExercicio(File arquivo) throws IOException{
        ArrayList<String> lista = FileManager.lerArquivo(arquivo);
        int posicao =1;

        for (String string : lista) {
            String[] partes = string.split(";");
            System.out.println("=========================================");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("Equipamento utilizado: " + partes[1]);
            System.out.println("=========================================");
            posicao++;
        }
    }
    
}