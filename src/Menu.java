import model.Aluno;
import repository.Repository;
import service.Service;
import view.View;

import java.util.Scanner;

public class Menu {
    static void main(String[] args) {
        // inicialização do scanner
        Scanner sc = new Scanner(System.in);
        // variável opção será utilizada na classe view.menu
        int opcao = 0;
        // criação das classes auxiliares
        View view = new View();
        Service service = new Service();

    // preenchimento de lista com objetos prédefinidos para facilitar testes
        Repository repository = new Repository();
        repository.criarObj(service);

        // repita o menu até que o usuário solicite a saída(opção = 5)
        do {
            // leitura da opção dentro de menu
            opcao = view.menu(sc);
            switch (opcao) {
                case 1:
                    // sempre que a opção CREATE for indicada no menu um aluno será obrigatoriamente criado
                    Aluno aluno = new Aluno();
                    // função para ler os inputs do usuário - dentro da função adicionar haverá uma chamada para validação de todos os inputs
                    view.adicionar(sc, aluno);
                    // depois de validado e adicionado os atributos a função adicionarLista adicionará o objeto no ArrayList
                    service.adicionarLista(aluno);
                    // processo de criação de aluno concluído!
                    break;
                case 2:
                    // listagem de lista de alunos
                    service.listarLista();
                    break;
                case 3:
                    // edição dos atributos dos objetos da lista de alunos
                    service.editarLista(sc);
                    break;
                case 4:
                    // exclusão dos objetos registrados na lista de aluno
                    service.excluir(sc);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção não localizada. Digite novamente:");
            }
        } while (opcao != 5);
    }
}
