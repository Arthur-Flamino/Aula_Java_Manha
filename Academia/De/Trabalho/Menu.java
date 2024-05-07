package Academia.De.Trabalho;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Academia.De.Trabalho.Classes.Aluno;
import Academia.De.Trabalho.Classes.Equipamento;
import Academia.De.Trabalho.Classes.Exercicio;
import Academia.De.Trabalho.Classes.FileManager;
import Academia.De.Trabalho.Classes.Instrutor;




public class Menu {

    public static void main(String[] args) throws IOException, ParseException  {
        File caminho = new File("./arquivos");
        FileManager.criarDiretorio(caminho);

        menu();
    }

    public static void menu() throws IOException, ParseException{
        Scanner scan = new Scanner(System.in);

        File arquivoTreino = new File("./arquivos/treino.txt");
        FileManager.criarArquivo(arquivoTreino);
        File arquivoAluno = new File("./arquivos/aluno.txt");
        FileManager.criarArquivo(arquivoAluno);
        File arquivoInstrutor = new File("./arquivos/instrutor.txt");
        FileManager.criarArquivo(arquivoInstrutor);
        File arquivoEquipamento = new File("./arquivos/equipamento.txt");
        FileManager.criarArquivo(arquivoEquipamento);
        File arquivoExercicio = new File("./arquivos/exercicio.txt");
        FileManager.criarArquivo(arquivoExercicio);

        int escolha = 7;

        do {
            System.out.println("--------- Menu ---------");
            System.out.println("[1] Treino");
            System.out.println("[2] Aluno");
            System.out.println("[3] Instrutor");
            System.out.println("[4] Equipamento");
            System.out.println("[5] Exercicio");
            System.out.println("[0] Sair");
            System.out.println("------------------------");
            System.out.print("\nEscolha uma ação: ");

            escolha = Integer.parseInt(scan.nextLine());
            switch (escolha) {
                case 0:
                    System.out.println("Saindo!");
                    break;
                case 1:
                    System.out.println("treino");
                    break;
                case 2:
                    menuAluno(scan, arquivoAluno);
                    break;
                case 3:
                    menuInstrutor(scan, arquivoInstrutor);
                    break;
                case 4:
                    menuEquipamento(scan, arquivoEquipamento);
                    break;
                case 5:
                    menuExercicios(scan, arquivoExercicio, arquivoEquipamento);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (escolha !=0);
    }

    public static void menuAluno(Scanner scan, File arquivoAluno) throws IOException{
        int escolhaAluno;

        do {
            System.out.println("--------- ALUNO ---------");
            System.out.println("[1] Cadastrar Aluno(a)");
            System.out.println("[2] Ver Alunos(as)");
            System.out.println("[3] Excluir Aluno(a)");
            System.out.println("[0] Sair");
            System.out.println("-------------------------");
            System.out.print("\nEscolha uma ação: ");
            escolhaAluno = Integer.parseInt(scan.nextLine());

            switch (escolhaAluno) {
                case 0:
                    System.out.println("Voltando para menu");
                    break;
                case 1:
                    System.out.print("Digite seu nome: ");
                    String nome = scan.nextLine();
    
                    System.out.print("(000.000.000-00)nesse formato\nDigite seu CPF: ");
                    String cpf = scan.nextLine();
                    
                    System.out.print("Digite seu endereço: ");
                    String endereco = scan.nextLine();
    
                    System.out.print("(dd/MM/yyyy)nesse formato\nDigite sua Data de nascimento: ");
                    String dataNasc = scan.nextLine();
    
                    System.out.print("(0000-0000)nesse formato\nDigite seu número de telefone: ");
                    String telefone = scan.nextLine();
    
                    Aluno aluno = new Aluno(nome, cpf, endereco, dataNasc, telefone);
                    aluno.cadastrarAluno(arquivoAluno);
                    System.out.println("Aluno cadastrado");
                    break;
                case 2:
                    Aluno.mostrarAluno(arquivoAluno);
                    break;
                case 3:
                    Aluno.mostrarAluno(arquivoAluno);
                    System.out.println("Digite a posição do aluno para DELETAR:");
                    int posicao = Integer.parseInt(scan.nextLine())-1;
                    FileManager.deletarItem(arquivoAluno, posicao);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }while (escolhaAluno !=0);
    }

    public static void menuInstrutor(Scanner scan, File arquivoInstrutor) throws IOException{
        int escolhaInstrutor;

        do {
            System.out.println("--------- INSTRUTOR ---------");
            System.out.println("[1] Cadastrar Instrutor(a)");
            System.out.println("[2] Ver Instrutor(es)");
            System.out.println("[3] Excluir Instrutor(a)");
            System.out.println("[0] Sair");
            System.out.println("-----------------------------");
            System.out.print("\nEscolha uma ação: ");
            escolhaInstrutor = Integer.parseInt(scan.nextLine());

            switch (escolhaInstrutor) {
                case 0:
                    System.out.println("Voltando para menu");
                    break;
                case 1:
                    System.out.print("Digite o nome do Instrutor: ");
                    String nome = scan.nextLine();

                    System.out.print("(000.000.000-00)nesse formato\nDigite seu CPF: ");
                    String cpf = scan.nextLine();

                    System.out.println("Digite o salário do Instrutor: ");
                    Double salario = Double.parseDouble(scan.nextLine());

                    System.out.print("Digite a expecialidade do Instrutor: ");
                    String expecialidade = scan.nextLine();

                    Instrutor instrutor = new Instrutor(nome, cpf, salario, expecialidade);
                    instrutor.cadastrarInstrutor(arquivoInstrutor);
                    System.out.println("Instrutor cadastrado");
                    break;
                case 2:
                    Instrutor.mostrarInstrutor(arquivoInstrutor);
                    break;
                case 3:
                    Instrutor.mostrarInstrutor(arquivoInstrutor);
                    System.out.println("Digite a posição do instrutor para DELETAR:");
                    int posicao = Integer.parseInt(scan.nextLine())-1;
                    FileManager.deletarItem(arquivoInstrutor, posicao);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        } while (escolhaInstrutor != 0);
    }

    public static void menuEquipamento(Scanner scan, File arquivoEquipamento) throws IOException{
        int escolhaEquipamento;

        do {
            System.out.println("--------- EQUIPAMENTO ---------");
            System.out.println("[1] Cadastrar Equipamento");
            System.out.println("[2] Ver Equipamento(s)");
            System.out.println("[3] Excluir Equipamento");
            System.out.println("[0] Sair");
            System.out.println("-----------------------------");
            System.out.print("\nEscolha uma ação: ");
            escolhaEquipamento = Integer.parseInt(scan.nextLine());

            switch (escolhaEquipamento) {
                case 0:
                System.out.println("Voltando para menu");
                    break;
                case 1:
                    System.out.print("Digite o nome do equipamento: ");
                    String nome = scan.nextLine();

                    System.out.print("Digite a Função do equipamento: ");
                    String funcao_equipamento = scan.nextLine();
            
                    Equipamento equipamento = new Equipamento(nome, funcao_equipamento);
                    equipamento.cadastrarEquipamento(arquivoEquipamento);
                    System.out.println("equipamento cadastrado");
                    break;
                case 2:
                    Equipamento.mostrarEquipamento(arquivoEquipamento);
                    break;
                case 3:
                    Equipamento.mostrarEquipamento(arquivoEquipamento);
                    System.out.println("Digite a posição do equipamento para DELETAR:");
                    int posicao = Integer.parseInt(scan.nextLine())-1;
                    FileManager.deletarItem(arquivoEquipamento, posicao);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (escolhaEquipamento != 0);
    }

        public static void menuExercicios(Scanner scan, File arquivoExercicio, File arquivoEquipamento) throws IOException{
            int escolhaExercicio;
            do {
                System.out.println("--------- EXERCICIO ---------");
                System.out.println("[1] Cadastrar Exercicio");
                System.out.println("[2] Ver Exercicio(s)");
                System.out.println("[3] Excluir Exercicio");
                System.out.println("[0] Sair");
                System.out.println("-----------------------------");
                System.out.print("\nEscolha uma ação: ");
                escolhaExercicio = Integer.parseInt(scan.nextLine());

                switch (escolhaExercicio) {
                    case 0:
                    System.out.println("Voltando para menu");
                        break;
                    case 1:
                        System.out.print("Digite o nome do exercicio: ");
                        String nome = scan.nextLine();

                        Equipamento.mostrarEquipamento(arquivoEquipamento);
                        System.out.print("Escolha o equipamento para adicionar: ");
                        int escolha = Integer.parseInt(scan.nextLine());

                        String equi = FileManager.lerArquivo(arquivoEquipamento).get(escolha - 1);
                        String [] dados = equi.split(";");

                        String nomeEqui = dados[0];
                        String funcaoEqui = dados[1];

                        Equipamento equipamento = new Equipamento(nomeEqui, funcaoEqui);
                        System.out.println("Execicio cadastrado");
                        break;
                    case 2:
                        Exercicio.mostrarExercicio(arquivoExercicio);
                        break;
                    case 3:
                        Exercicio.mostrarExercicio(arquivoExercicio);
                        System.out.println("Digite a posição do equipamento para DELETAR:");
                        int posicao = Integer.parseInt(scan.nextLine())-1;
                        FileManager.deletarItem(arquivoExercicio, posicao);
                        break;
                    default:
                    System.out.println("Opção invalida!");
                        break;
                }
            } while (escolhaExercicio != 0);
        }
    }

