package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Treino {
    

    private Aluno aluno;
    private Instrutor instrutor;
    private Exercicio exercicio;

    // Construtor da classe treino
    public Treino(Aluno aluno, Instrutor instrutor, Exercicio exercicio) {
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.exercicio = exercicio;
    }

    // Getters para as variáveis de instância
    public Aluno getAluno() {
        return aluno;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }
    
    public Exercicio getExercicio() {
        return exercicio;
    }

     // Método para cadastrar um treino em um arquivo
    public void cadastrarTreino(File arquivo) throws IOException{
        // Verifica se o arquivo não existe e, se não, cria um novo arquivo
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        // Escreve os dados do treino no arquivo
        FileManager.escreverArquivo(arquivo, this.aluno.getNome() + ";" + this.instrutor.getNome() + ";" + this.exercicio.getNome() + ";", true);
    }

    // Método estático para mostrar os trinos a partir de um arquivo
    public static void mostrarTreino(File arquivo) throws IOException{
        // Lê os dados do arquivo para uma lista
        ArrayList<String> lista = FileManager.lerArquivo(arquivo);
        int posicao =1;

         // Itera sobre cada linha da lista e imprime os detalhes do treino
        for (String string : lista) {
            String[] partes = string.split(";");
            System.out.println("/-----------------------------------------\\");
            System.out.println("Posição: " + posicao);
            System.out.println("Aluno: " + partes[0]);
            System.out.println("Instrutor: " + partes[1]);
            System.out.println("Exercicio: " + partes[2]);
            System.out.println("\\-----------------------------------------/\n");
            posicao++;
        }
    }


    
}
