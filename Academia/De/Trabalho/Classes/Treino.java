package Academia.De.Trabalho.Classes;

public class Treino {
    
    private Aluno aluno;
    private Instrutor instrutor;
    private Equipamento equipamento;
    private String data;


    public Treino(Aluno aluno, Instrutor instrutor, Equipamento equipamento, String data) {
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.equipamento = equipamento;
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public Instrutor getInstrutor() {
        return instrutor;
    }
    public Equipamento getEquipamento() {
        return equipamento;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    
}
