package repository;

import model.Aluno;
import service.Service;

import java.util.Scanner;

public class Repository {
        public void criarObj(Service service){
            Scanner sc = new Scanner(System.in);
            Aluno aluno1 = new Aluno();
            Aluno aluno2 = new Aluno();

            aluno1.setNome("Enzo Yudi");
            aluno1.setEndereco("Flowers, 744 - Gardens");
            aluno1.setDataNascimento("19/07/2023", sc);
            aluno1.setNomeResponsavel("Jorge Roberto");
            aluno1.setTelefone("(11)99999-9999");

            aluno2.setNome("Cleber Augusto");
            aluno2.setEndereco("Soccer, 123 - Sports");
            aluno2.setDataNascimento("22/09/2022", sc);
            aluno2.setNomeResponsavel("Maria Lucia");
            aluno2.setTelefone("(11)88888-8888");

            aluno1.calcularIdade();
            service.adicionarLista(aluno1);
            aluno2.calcularIdade();
            service.adicionarLista(aluno2);

            // por que não está listando?
            // 22/09/2022 - data de nascimento consta como null?
            System.out.println("toString 1: " + aluno1.toString());
            System.out.println("toString 2: " + aluno2.toString());
        }
}
