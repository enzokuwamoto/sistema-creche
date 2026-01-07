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

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return "Aluno{ra=" + ra +
                ", nome='" + nome + '\'' +
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
        if (idade.getYears() > 4) {
            System.out.println("Digite uma idade válida. Crianças maiores que 3 anos não podem ser cadastradas.");
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
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
            setTelefone("Não adequado");
        }
        return segmento;
    }
}
