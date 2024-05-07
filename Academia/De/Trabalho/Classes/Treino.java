package Academia.De.Trabalho.Classes;

import java.io.File;
import java.io.IOException;

public class Treino {
    
    private Aluno aluno;
    private Instrutor instrutor;
    private Exercicio exercicio;
    private String data;


    public Treino(Aluno aluno, Instrutor instrutor, Exercicio exercicio, String data) {
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.exercicio = exercicio;
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public Instrutor getInstrutor() {
        return instrutor;
    }
    public Exercicio getExercicio() {
        return exercicio;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public void cadastrarTreino(File arquivo) throws IOException{
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }
        FileManager.escreverArquivo(arquivo, this.aluno + ";" + this.instrutor + ";" + this.exercicio + ";" + this.data + ";", true);
    }


    
}
