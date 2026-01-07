import model.Aluno;
import model.Endereco;
import repository.Repository;
import service.Service;
import view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        View view = new View();
        Service service = new Service();
        Repository repository = new Repository();
        repository.criarObj(service);
        do {
            opcao = view.menu(sc);
            switch (opcao) {
                case 1:
                    Aluno aluno = new Aluno();
                    Endereco endereco = view.adicionar(sc, aluno);
                    service.adicionarLista(aluno);
                    System.out.println(aluno.toString());
                    break;
                case 2:
                    service.listarLista();
                    break;
                case 3:
                    service.editarLista(sc);
                    break;
                case 4:
                    service.excluir(sc);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção não localizada. Digite novamente:");
            }
        } while (opcao != 5);
    }
}
