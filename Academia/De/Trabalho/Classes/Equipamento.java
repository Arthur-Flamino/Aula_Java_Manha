package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Equipamento {
    private String nome;
    private String funcao_equipamento;

    public Equipamento(String nome, String funcao_equipamento) {
        this.nome = nome;
        this.funcao_equipamento = funcao_equipamento;
    }

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

    public void cadastrarEquipamento(File arquivo) throws IOException{
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.funcao_equipamento + ";", true);
    }

    public static void mostrarEquipamento(File arquivo) throws IOException{
        ArrayList<String> lista = FileManager.lerArquivo(arquivo);
        int posicao =1;

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
