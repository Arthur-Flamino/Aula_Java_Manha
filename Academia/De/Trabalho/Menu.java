package Academia.De.Trabalho;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import Academia.De.Trabalho.Classes.Aluno;
import Academia.De.Trabalho.Classes.Equipamento;
import Academia.De.Trabalho.Classes.Exercicio;
import Academia.De.Trabalho.Classes.FileManager;
import Academia.De.Trabalho.Classes.Instrutor;
import Academia.De.Trabalho.Classes.Treino;

public class Menu {

    public static void main(String[] args) throws IOException, ParseException  {
        // Cria um diretório para armazenar os arquivos, se ainda não existir
        File caminho = new File("./arquivos");
        FileManager.criarDiretorio(caminho);

        // Inicia o menu
        menu();
    }

    // Método para validar o formato do CPF
    public static boolean validarCPF(String cpf){
        if(!cpf.matches("\\d{11}")){
            return false;
        }
        return true;
    }

    // Método para validar o formato do número de telefone
    public static boolean validarTelefone(String telefone){
        if (!telefone.matches("\\d{8}| \\d{9}")) {
            return false;
        }
        return true;
    }

    // Método que exibe o menu principal
    public static void menu() throws IOException, ParseException{
        Scanner scan = new Scanner(System.in);

        // Criação dos arquivos necessários se ainda não existirem
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
            // Exibe o menu principal e solicita uma escolha ao usuário
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
                    menuTreino(scan, arquivoTreino, arquivoAluno, arquivoInstrutor, arquivoExercicio);
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

    // Método que gerencia as opções relacionadas a treinos
    private static void menuTreino(Scanner scan, File arquivoTreino, File arquivoAluno, File arquivoInstrutor, File arquivoExercicio)
    throws IOException {
        int escolhaTreino;

        do {

            // Exibe o menu de treinos e solicita uma escolha ao usuário
            System.out.println("--------- TREINO ---------");
            System.out.println("[1] Cadastrar Treino");
            System.out.println("[2] Ver Treino(s)");
            System.out.println("[3] Excluir Treino");
            System.out.println("[0] Sair");
            System.out.println("-------------------------");
            System.out.print("\nEscolha uma ação: ");
            escolhaTreino = Integer.parseInt(scan.nextLine());

            switch (escolhaTreino) {
                case 0:
                    System.out.println("Voltando para menu");
                    break;
                case 1:
                    // Cadastro de um novo treino
                    Aluno.mostrarAluno(arquivoAluno);
                    System.out.print("Escolha um Aluno: ");
                    int alunoEscolha = Integer.parseInt(scan.nextLine());

                    // Verifica se a escolha do aluno é válida
                    List<String> alunos = FileManager.lerArquivo(arquivoAluno);
                    if (alunoEscolha <= 0 || alunoEscolha > alunos.size()) {
                        System.out.println("Escolha invalida");
                        break;
                    }

                    // Obtém os dados do aluno selecionado
                    String alu = alunos.get(alunoEscolha - 1);
                    String [] dadosAlu = alu.split(";");
                    String nomeAlu = dadosAlu[0];
                    String cpfAlu = dadosAlu[1];
                    String enderecoAlu = dadosAlu[2];
                    String dataNascAlu = dadosAlu[3];
                    String telefoneAlu = dadosAlu[4];

                    // Cria um objeto Aluno com os dados obtidos
                    Aluno aluno = new Aluno(nomeAlu, cpfAlu, enderecoAlu, dataNascAlu, telefoneAlu);
                    
                    // Exibe os instrutores disponíveis
                    Instrutor.mostrarInstrutor(arquivoInstrutor);
                    System.out.print("Escolha um Instrutor: ");
                    int instrutorEscolha = Integer.parseInt(scan.nextLine());

                    // Verifica se a escolha do instrutor é válida
                    List<String> instrutores = FileManager.lerArquivo(arquivoInstrutor);
                    if (instrutorEscolha <= 0 || instrutorEscolha > instrutores.size()) {
                        System.out.println("Escolha invalida");
                        break;
                    }

                    // Obtém os dados do instrutor selecionado
                    String inst = instrutores.get(instrutorEscolha - 1);
                    String [] dadosInst = inst.split(";");
                    String nomeInst = dadosInst[0];
                    String cpfInst = dadosInst[1];
                    Double salarioInst = Double.parseDouble( dadosInst[2]);
                    String expecialidadeInst = dadosInst[3];

                    // Cria um objeto Instrutor com os dados obtidos
                    Instrutor instrutor = new Instrutor(nomeInst, cpfInst, salarioInst, expecialidadeInst);

                    // Exibe os exercícios disponíveis
                    Exercicio.mostrarExercicio(arquivoExercicio);
                    System.out.print("Escolha um exercicio: ");
                    int exercicioEscolha = Integer.parseInt(scan.nextLine());

                    // Verifica se a escolha do exercício é válida
                    List<String> exercicios = FileManager.lerArquivo(arquivoExercicio);
                    if (exercicioEscolha <=0 || exercicioEscolha > instrutores.size()) {
                        System.out.println("Escolha invalida");
                        break;
                    }

                    // Obtém os dados do exercício selecionado
                    String exer = exercicios.get(exercicioEscolha - 1);
                    String [] dadosExer = exer.split(";");
                    String nomeExer = dadosExer[0];
                    Equipamento equipamentoExer = new Equipamento(dadosExer[1]);

                    // Cria um objeto Exercicio com os dados obtidos
                    Exercicio exercicio = new Exercicio(nomeExer, equipamentoExer);

                    // Cadastra o treino com os objetos Aluno, Instrutor e Exercicio
                    Treino treino = new Treino(aluno, instrutor, exercicio);
                    treino.cadastrarTreino(arquivoTreino);
                    System.out.println("Treino cadastrado");
                    break;
                case 2:
                    // Exibe os treinos cadastrados
                    Treino.mostrarTreino(arquivoTreino);
                    break;
                case 3:
                    // Exibe os treinos cadastrados e permite excluir um treino
                    Treino.mostrarTreino(arquivoTreino);
                    System.out.println("Digite a posição do treino para DELETAR:");
                    int posicao = Integer.parseInt(scan.nextLine())-1;
                    FileManager.deletarItem(arquivoTreino, posicao);
                default:
                System.out.println("Opção invalida!");
                    break;
            }

        } while (escolhaTreino !=0);
    }

    // Método que gerencia as opções relacionadas a alunos
    public static void menuAluno(Scanner scan, File arquivoAluno) throws IOException{
        int escolhaAluno;

        do {
            // Exibe o menu de alunos e solicita uma escolha ao usuário
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
                    // Cadastro de um novo aluno
                    System.out.print("Digite seu nome: ");
                    String nome = scan.nextLine();
    
                    System.out.print("(00000000000)nesse formato\nDigite seu CPF: ");
                    String cpf = scan.nextLine();
                    if (!validarCPF(cpf)) {
                        System.out.println("CPF com poucos caracteres");
                        break;
                    }
                    System.out.print("Digite seu endereço: ");
                    String endereco = scan.nextLine();
    
                    System.out.print("(dd/MM/yyyy)nesse formato\nDigite sua Data de nascimento: ");
                    String dataNasc = scan.nextLine();
    
                    System.out.print("(00000000 com 8 ou 9 números)nesse formato\nDigite seu número de telefone: ");
                    String telefone = scan.nextLine();
                    if (!validarTelefone(telefone)) {
                        System.out.println("telefone com poucos caracteres");
                        break;
                    }
    
                    // Cria um objeto Aluno com os dados informados e o cadastra
                    Aluno aluno = new Aluno(nome, cpf, endereco, dataNasc, telefone);
                    aluno.cadastrarAluno(arquivoAluno);
                    System.out.println("Aluno cadastrado");
                    break;
                case 2:
                    // Exibe os alunos cadastrados
                    Aluno.mostrarAluno(arquivoAluno);
                    break;
                case 3:
                    // Exibe os alunos cadastrados e permite excluir um aluno
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

    // Método que gerencia as opções relacionadas a instrutores
    public static void menuInstrutor(Scanner scan, File arquivoInstrutor) throws IOException{
        int escolhaInstrutor;

        do {
            // Exibe o menu de instrutores e solicita uma escolha ao usuário
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
                    // Cadastro de um novo instrutor
                    System.out.print("Digite o nome do Instrutor: ");
                    String nome = scan.nextLine();

                    System.out.print("(00000000000)nesse formato\nDigite seu CPF: ");
                    String cpf = scan.nextLine();
                    if (!validarCPF(cpf)) {
                        System.out.println("CPF com poucos caracteres");
                        break;
                    }

                    System.out.print("Digite o salário do Instrutor: ");
                    Double salario = Double.parseDouble(scan.nextLine());

                    System.out.print("Digite a expecialidade do Instrutor: ");
                    String expecialidade = scan.nextLine();

                    // Cria um objeto Instrutor com os dados informados e o cadastra
                    Instrutor instrutor = new Instrutor(nome, cpf, salario, expecialidade);
                    instrutor.cadastrarInstrutor(arquivoInstrutor);
                    System.out.println("Instrutor cadastrado");
                    break;
                case 2:
                    // Exibe os instrutores cadastrados
                    Instrutor.mostrarInstrutor(arquivoInstrutor);
                    break;
                case 3:
                    // Exibe os instrutores cadastrados e permite excluir um instrutor
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

    // Método que gerencia as opções relacionadas a equipamentos
    public static void menuEquipamento(Scanner scan, File arquivoEquipamento) throws IOException{
        int escolhaEquipamento;

        do {
            // Exibe o menu de equipamentos e solicita uma escolha ao usuário
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
                    // Cadastro de um novo equipamento
                    System.out.print("Digite o nome do equipamento: ");
                    String nome = scan.nextLine();

                    System.out.print("Digite a Função do equipamento: ");
                    String funcao_equipamento = scan.nextLine();
            
                    // Cria um objeto Equipamento com os dados informados e o cadastra
                    Equipamento equipamento = new Equipamento(nome, funcao_equipamento);
                    equipamento.cadastrarEquipamento(arquivoEquipamento);
                    System.out.println("equipamento cadastrado");
                    break;
                case 2:
                    // Exibe os equipamentos cadastrados
                    Equipamento.mostrarEquipamento(arquivoEquipamento);
                    break;
                case 3:
                    // Exibe os equipamentos cadastrados e permite excluir um equipamento
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

    // Método que gerencia as opções relacionadas a exercícios
    public static void menuExercicios(Scanner scan, File arquivoExercicio, File arquivoEquipamento) throws IOException{
        int escolhaExercicio;
        do {
            // Exibe o menu de exercícios e solicita uma escolha ao usuário
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
                    // Cadastro de um novo exercício
                    System.out.print("Digite o nome do exercicio: ");
                    String nome = scan.nextLine();

                    // Exibe os equipamentos disponíveis
                    Equipamento.mostrarEquipamento(arquivoEquipamento);
                    System.out.print("Escolha o equipamento para adicionar: ");
                    int escolha = Integer.parseInt(scan.nextLine());

                    // Verifica se a escolha do equipamento é válida
                    List<String> equipamentos = FileManager.lerArquivo(arquivoEquipamento);
                    if (escolha <= 0 || escolha > equipamentos.size()) {
                        System.out.println("Escolha invalida");
                        break;
                    }
                    // Obtém os dados do equipamento selecionado
                    String equi = equipamentos.get(escolha - 1);
                    String [] dados = equi.split(";");

                    String nomeEqui = dados[0];
                    String funcaoEqui = dados[1];

                    // Cria um objeto Equipamento com os dados obtidos
                    Equipamento equipamento = new Equipamento(nomeEqui, funcaoEqui);
                    
                    // Cria um objeto Exercicio com os dados informados e o cadastra
                    Exercicio exercicio = new Exercicio(nome, equipamento);
                    exercicio.cadastrarExercicio(arquivoExercicio);

                    System.out.println("Exercicio cadastrado");
                    break;
                case 2:
                    // Exibe os exercícios cadastrados
                    Exercicio.mostrarExercicio(arquivoExercicio);
                    break;
                case 3:
                    // Exibe os exercícios cadastrados e permite excluir um exercício
                    Exercicio.mostrarExercicio(arquivoExercicio);
                    System.out.println("Digite a posição do exercício para DELETAR:");
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
