package validations;

import model.Aluno;
import model.Endereco;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validations {
    public int validarOpcao(Scanner sc) {
        int opcao = 0;
        boolean valido = false;
        do {
            try {
                opcao = sc.nextInt();
                sc.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                valido = false;
                System.out.println("Erro: Opção Inválida. Tente novamente.");
                sc.nextLine();
            }
        } while (!valido);
        return opcao;
    }
// possibilidade de usar uma só função para validar nomes, seja de alunos ou responsáveis
    public void validarNome(Scanner sc, Aluno aluno, char op) {
        // uso de uma só função para nomes - aluno 'a' / responsável 'r'
        boolean valido = false;
        while (!valido) {
            try {
                String nomeInput = sc.nextLine();
                if (op == 'a') {
                    aluno.setNome(nomeInput);
                } else if (op == 'r') {
                    aluno.setNomeResponsavel(nomeInput);
                }
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
                validarNome(sc, aluno, op);
            }
        }
    }

    public void validarDataNascimento(Scanner sc, Aluno aluno) {
        boolean validado = false;
        do {
            try {
                validado = aluno.setDataNascimento(sc.nextLine(), sc);
            } catch (DateTimeParseException e) {
                System.out.println("Digite uma data válida.");
            }
        }
        while (!validado);
    }

    public void validarTelefone(Scanner sc, Aluno aluno) {
        try {
            String telInput = sc.nextLine();
            aluno.setTelefone(telInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            validarTelefone(sc, aluno);
        }
    }
// possibilidade de usar uma só função para validar todos os segmentos do endereço
    public String validarEndereco(Scanner sc, Endereco endereco, char op) {
        // uso de uma só função para nomes - rua 'r' / bairro 'b' / número 'n'
        boolean valido = false;
        String input = "";
        do {
            try {
                input = sc.nextLine();
                if (op == 'r') {
                    endereco.setRua(input);
                } else if (op == 'b') {
                    endereco.setBairro(input);
                } else if (op == 'n'){
                    endereco.setNumero(input);
                }
                valido = true;
            } catch (IllegalArgumentException e) {
                valido = false;
                System.out.println("Erro: Dado preenchido inválido. Tente novamente.");
            }
        } while (!valido);
        return input;
    }
    public void validarDataNascimento(){

    }
    }



