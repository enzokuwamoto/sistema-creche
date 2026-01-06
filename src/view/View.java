package view;

import model.Aluno;

import java.util.Scanner;

public class View {
    public int menu(Scanner sc) {
        System.out.println("\n♥ CRECHE LAR DOCE LAR ♥ | sistemas de alunos");
        System.out.println("[1] Cadastrar");
        System.out.println("[2] Listar");
        System.out.println("[3] Editar");
        System.out.println("[4] Excluir");
        System.out.println("[5] Sair");
        System.out.println("\nEscolha:");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public void adicionar(Scanner sc, Aluno aluno) {
        boolean validado;
        System.out.println("\nDigite o nome do aluno:");
        aluno.setNome(sc.nextLine());
        System.out.println("Digite o endereço: (Rua, número - Bairro)");
        aluno.setEndereco(sc.nextLine());
        System.out.println("Digite a data de nascimento:");
        do {
            validado = aluno.setDataNascimento(sc.nextLine(), sc);
        } while (!validado);
        System.out.println("Digite o nome do responsável:");
        aluno.setNomeResponsavel(sc.nextLine());
        System.out.println("Digite o numero de telefone:");
        aluno.setTelefone(sc.nextLine());
        System.out.println("-------------------------");
        System.out.println("Aluno Cadastrado!");
    }
}
