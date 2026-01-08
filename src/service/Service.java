package service;

import model.Aluno;
import model.Endereco;
import validations.Validations;

import java.util.*;

public class Service {
    // validar input na função editarLista
    Validations validations = new Validations();
    // ArrayList para armazenar os dados inputados na função adicionar do pacote view
    List<Aluno> alunos = new ArrayList<>();
    // chave para localizar o RA nas buscar do editarLista e excluirLista
    boolean encontrado = false;


    public void adicionarLista(Aluno aluno) {
        alunos.add(aluno);
    }

    public void listarLista() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }
        System.out.println("Listagem dos alunos cadastrados:\n");
        // listar em ordem alfabéticas os nomes
        alunos.sort(Comparator.comparing(Aluno::getNome));

        for (Aluno aluno1 : alunos) {
            System.out.print("RA: " + aluno1.getRa());
            System.out.print("|Nome: " + aluno1.getNome());
            System.out.print("|Sexo: " + aluno1.getSexo());
            System.out.print("|Endereço: " + aluno1.getEndereco().getEnderecoCompleto());
            System.out.print("|Data Nascimento: " + aluno1.getDataNascimento());
            System.out.print("|Segmento: " + aluno1.getSegmento());
            System.out.print("|Nome Responsável: " + aluno1.getNomeResponsavel());
            System.out.print("|Telefone: " + aluno1.getTelefone() + "\n");
        }
    }

    public void editarLista(Scanner sc) {
        int opcao = 0;
        boolean validado = false;
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }
// do-while para validar se realmente existe o RA
        do {
            listarLista();
            System.out.println("\nDigite o RA do cadastro que será atualizado:");
            int RaBusca = sc.nextInt();

            for (Aluno aluno1 : alunos) {
                if (aluno1.getRa() == RaBusca) {
                    encontrado = true;
                    do {
                        System.out.println("\nQual critério deseja alterar?");
                        System.out.println("[1] Nome");
                        System.out.println("[2] Endereço");
                        System.out.println("[3] Nome Responsável");
                        System.out.println("[4] Telefone");
                        System.out.println("[5] Sair");
                        opcao = sc.nextInt();
                        sc.nextLine();
                        switch (opcao) {
                            case 1:
                                System.out.println("Digite o nome para alteração:");
                                validations.validarNome(sc, aluno1, 'a');
                                break;
                            case 2:
                                validado = false;
                                do {
                                    System.out.println("Digite qual parte do endereço será alterado:");
                                    System.out.println("[1] Rua");
                                    System.out.println("[2] Bairro");
                                    System.out.println("[3] Número");
                                    int opcaoAninhada = sc.nextInt();
                                    sc.nextLine();
                                    Endereco endereco = aluno1.getEndereco();
                                    if (opcaoAninhada == 1) {
                                        System.out.println("Digite a rua:");
                                        endereco.setRua(validations.validarEndereco(sc, endereco, 'r'));
                                        validado = true;
                                    } else if (opcaoAninhada == 2) {
                                        System.out.println("Digite o bairro:");
                                        endereco.setBairro(validations.validarEndereco(sc, endereco, 'b'));
                                        validado = true;
                                    } else if (opcaoAninhada == 3) {
                                        System.out.println("Digite o número:");
                                        endereco.setNumero(validations.validarEndereco(sc, endereco, 'n'));
                                        validado = true;
                                    } else {
                                        System.out.println("Opção não localizada.");
                                    }
                                } while (!validado);
                                break;
                            case 3:
                                System.out.println("Digite o nome do responsável para alteração:");
                                validations.validarNome(sc, aluno1, 'r');
                                break;
                            case 4:
                                System.out.println("Digite o número de telefone para alteração: ex.:(XX) 9XXXX-XXXX");
                                validations.validarTelefone(sc, aluno1);
                                break;
                            case 5:
                                System.out.println("Saindo da busca por critério.");
                                break;
                            default:
                                System.out.println("Opção não localizada. Digite novamente:");
                        }
                    } while (opcao != 5);
                    break;
                } else {
                    System.out.println("Busca não localizada. Revise os critérios de busca");
                }
            }
        } while (!encontrado);
    }

    public void excluir(Scanner sc) {
        encontrado = false;
// do-while para validar se realmente existe o RA
        do {
            listarLista();
            System.out.println("\nDigite o RA do cadastro que será excluido:");
            int raBusca = sc.nextInt();

            Iterator<Aluno> a = alunos.iterator();
            while (a.hasNext()) {
                Aluno alunoAtual = a.next();
                if (alunoAtual.getRa() == raBusca) {
                    encontrado = true;
                    a.remove();
                    System.out.println("Aluno " + alunoAtual.getNome() + " removido.");
                } else {
                    System.out.println("RA não localizado!");
                }
            }
        } while (!encontrado);
    }
}
