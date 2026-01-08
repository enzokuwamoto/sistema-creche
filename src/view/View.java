package view;

import model.Aluno;
import model.Endereco;
import validations.Validations;

import java.util.Scanner;

public class View {
    Validations validations = new Validations();
    public int menu(Scanner sc) {
        System.out.println("\n♥ CRECHE LAR DOCE LAR ♥ | sistemas de alunos\n");
        System.out.println("[1] Cadastrar");
        System.out.println("[2] Listar");
        System.out.println("[3] Editar");
        System.out.println("[4] Excluir");
        System.out.println("[5] Sair");
        System.out.println("\nEscolha:");
        int opcao = validations.validarOpcao(sc);
        return opcao;
    }

    public void adicionar(Scanner sc, Aluno aluno) {
        boolean validado = false;
        // chave para reciclar funções validarNome para alunos e responsáveis e também a função validarEndereços para rua, bairro e número
        char op;
        // input do nome deverá seguir algumas restrições como: input não deverá ser vazio, apenas caracteres alfabéticos e precisará ser preenchido com nome e sobrenome
        System.out.println("\nDigite o nome do aluno:");
        validations.validarNome(sc, aluno, 'a');
        do {
            System.out.println("Digite o sexo do aluno: (F/M)");
            validado = aluno.setSexo(sc.next().charAt(0));
            sc.nextLine();
        } while (!validado);

        // centralização dos inputs do endereço em uma só função, diferenciando pelo 'op' listado para mudar o set na classe endereço
        Endereco endereco = new Endereco();
        System.out.println("|Endereço|");

        System.out.println("Digite a rua:");
        endereco.setRua(validations.validarEndereco(sc, endereco, 'r'));

        System.out.println("Digite o número:");
        endereco.setNumero(validations.validarEndereco(sc, endereco, 'n'));

        System.out.println("Digite o bairro:");
        endereco.setBairro(validations.validarEndereco(sc, endereco, 'b'));

        aluno.setEndereco(endereco);

        System.out.println("Digite a data de nascimento:");
        validations.validarDataNascimento(sc, aluno);

        // input do nome deverá seguir algumas restrições como: input não deverá ser vazio, apenas caracteres alfabéticos e precisará ser preenchido com nome e sobrenome
        System.out.println("Digite o nome do responsável:");
        validations.validarNome(sc, aluno, 'r');

        // input do telefone deverá seguir algumas restrições como: input não deverá ser vazio, apenas caracteres alfanúmericos e precisará ser preenchido no modelo ((XX) XXXXX-XXXX)
        System.out.println("Digite o número de telefone: ex.: (XX) 9XXXX-XXXX");
        validations.validarTelefone(sc, aluno);

        // função para calcular a idade (dataAtual - dataNascimento) e definir o segmento
        aluno.calcularIdade();

        System.out.println("Aluno " + aluno.getNome() + " cadastrado!");
    }
}

