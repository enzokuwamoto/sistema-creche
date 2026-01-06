package service;

import model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public class Service {
    List<Aluno> alunos = new ArrayList<>();

    public void adicionarLista(Aluno aluno) {
        alunos.add(aluno);
    }

    public void listarLista() {
        System.out.println("Listagem dos alunos cadastrados:\n");
        // listar em ordem alfabéticas os nomes
        alunos.sort(Comparator.comparing(Aluno::getNome));
        for (Aluno aluno1 : alunos) {
            System.out.print("RA: " + aluno1.getRa());
            System.out.print("| Nome: " + aluno1.getNome());
            System.out.print("| Endereço: " + aluno1.getEndereco());
            System.out.print("| Data Nascimento: " + aluno1.getDataNascimento());
            System.out.print("| Segmento: " + aluno1.getSegmento());
            System.out.print("| Nome Responsável: " + aluno1.getNomeResponsavel());
            System.out.print("| Telefone: " + aluno1.getTelefone() + "\n");
        }
    }

    public void editarLista(Scanner sc) {
        int opcao = 0;
        listarLista();
        System.out.println("\nDigite o RA do cadastro que será atualizado:");
        int RaBusca = sc.nextInt();
        for (Aluno aluno1 : alunos) {
            int RaAtual = aluno1.getRa();
            if (RaAtual == RaBusca) {
                do {
                    System.out.println("\nQual critério deseja alterar?");
                    System.out.println("[1] Nome");
                    System.out.println("[2] Endereço");
                    System.out.println("[3] Data de Nascimento");
                    System.out.println("[4] Nome Responsável");
                    System.out.println("[5] Telefone");
                    System.out.println("[6] Sair");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o nome para alteração:");
                            aluno1.setNome(sc.nextLine());
                            break;
                        case 2:
                            System.out.println("Digite o endereço para alteração:");
                            aluno1.setEndereco(sc.nextLine());
                            break;
                        case 3:
                            System.out.println("Digite a data de nascimento para alteração:");
                            boolean validado;
                            do {
                                validado = aluno1.setDataNascimento(sc.nextLine(), sc);
                            } while (!validado);
                            break;
                        case 4:
                            System.out.println("Digite o nome do responsável para alteração:");
                            aluno1.setNomeResponsavel(sc.nextLine());
                            break;
                        case 5:
                            System.out.println("Digite o número de telefone para alteração:");
                            aluno1.setTelefone(sc.nextLine());
                            break;
                        case 6:
                            System.out.println("Saindo da busca por critério.");
                            break;
                        default:
                            System.out.println("Opção não localizada. Digite novamente:");
                    }
                } while (opcao != 6);
                break;
            } else {
                System.out.println("Busca não localizada. Revise os critérios de busca");
            }
        }
    }

    public void excluir(Scanner sc) {
        listarLista();
        System.out.println("\nDigite o RA do cadastro que será excluido:");
        int RaBusca = sc.nextInt();
        for (Aluno aluno1 : alunos) {
            int RaAtual = aluno1.getRa();
            if (RaAtual == RaBusca) {
                alunos.remove(aluno1);
                System.out.println("Aluno " + aluno1 + " removido.");
            }
        }
    }
}
// adicionar, listar, buscar e excluir pelo array
