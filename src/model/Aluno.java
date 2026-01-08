package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Aluno {
    private static int contador;
    private int ra;
    private String nome;
    private LocalDate dataNascimento;
    private String segmento;
    private String nomeResponsavel;
    private String telefone;
    private Endereco endereco;
    private String sexo;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return "Aluno{ra=" + ra +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", endereco='" + endereco.getEnderecoCompleto() + '\'' +
                ", dataNascimento=" + dataNascimento.format(FORMATTER) +
                ", segmento='" + this.segmento + '\'' +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public Aluno() {
        contador += 1;
        this.ra = contador;
    }

    public int getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento.format(FORMATTER);
    }

    public boolean setDataNascimento(String dataNascimentoTemp, Scanner sc) {



        boolean validado = false;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dataNascimentoTemp, formato);
        Period idade = Period.between(localDate, LocalDate.now());


        if(idade.getYears() < 0){
            System.out.println("Digite uma idade válida.");
        }
        else if (idade.getYears() > 4 ) {
            System.out.println("Crianças maiores que 3 anos não podem ser cadastradas.");
        } else if (idade.getMonths() < 3) {
            System.out.println("Crianças menores de 3 meses não podem ser registradas.");
        } else {
            this.dataNascimento = localDate;
            validado = true;
        }
        return validado;
    }


    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        validacaoNome(nomeResponsavel);
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("O campo de telefone deve ser preenchido.");
        }
        if (!telefone.matches("^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}$")) {
            throw new IllegalArgumentException("O número de telefone deve ser preenchido no padrão correto.");
        }
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean setSexo(Character sexoOp) {
        boolean validado = false;
        switch (sexoOp.toString().toUpperCase()) {
            case "F":
                this.sexo = "Feminino";
                validado = true;
                break;
            case "M":
                this.sexo = "Masculino";
                validado = true;
                break;
            default:
                System.out.println("Opção não localizada.");
        }
        return validado;
    }

    public String calcularIdade() {
        Period periodo = Period.between(this.dataNascimento, LocalDate.now());
        if (periodo.getYears() == 0) {
            if (periodo.getMonths() > 3 && periodo.getMonths() <= 10) {
                setSegmento("Berçario");
            } else if (periodo.getMonths() == 11) {
                setSegmento("Berçario II");
            }
        } else if (periodo.getYears() == 1) {
            if (periodo.getMonths() <= 4) {
                setSegmento("Berçario II");
            } else if (periodo.getMonths() >= 5 && periodo.getMonths() <= 11) {
                setSegmento("Berçario III");
            }
        } else if (periodo.getYears() == 2) {
            setSegmento("Maternal I");
        } else if (periodo.getYears() >= 3 && periodo.getYears() <= 4) {
            setSegmento("Maternal II");
        } else {
            System.out.println("Idade não está de acordo");
        }
        return segmento;
    }

    // função utilizada para os atributos nome e nomeResponsável
    public void validacaoNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O campo de nome deve ser preenchido.");
        }
        if (!nome.contains(" ") || !nome.matches("[A-Za-zÀ-ÿ ]+")) {
            throw new IllegalArgumentException("O aluno deve ter um nome e sobrenome");
        }
    }

}
