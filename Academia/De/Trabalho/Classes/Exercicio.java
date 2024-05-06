package Academia.De.Trabalho.Classes;

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


    public Equipamento getEquipamento() {
        return equipamento;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    
    
    
}