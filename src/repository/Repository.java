package repository;

import model.Aluno;
import model.Endereco;
import service.Service;

import java.util.Scanner;

// preenchimento de dados - Data Seeding
public class Repository {
        public void criarObj(Service service){
            Scanner sc = new Scanner(System.in);

            Aluno aluno1 = new Aluno();
            Aluno aluno2 = new Aluno();

            aluno1.setNome("Enzo Yudi");
            aluno1.setSexo('m');
            Endereco endereco1 = new Endereco();
            endereco1.setRua("Flowers");
            endereco1.setNumero("999");
            endereco1.setBairro("Gardens");
            aluno1.setEndereco(endereco1);
            aluno1.setDataNascimento("19/07/2023", sc);
            aluno1.setNomeResponsavel("Kuwamoto Yano");
            aluno1.setTelefone("(11) 99999-9999");

            service.adicionarLista(aluno1);

            aluno2.setNome("Cleber Augusto");
            aluno2.setSexo('m');
            Endereco endereco2 = new Endereco();
            endereco2.setRua("Soccer");
            endereco2.setNumero("777");
            endereco2.setBairro("Sports");
            aluno2.setEndereco(endereco2);
            aluno2.setDataNascimento("22/09/2022", sc);
            aluno2.setNomeResponsavel("Maria Lucia");
            aluno2.setTelefone("(11) 98888-8888");

            service.adicionarLista(aluno2);
        }
}
