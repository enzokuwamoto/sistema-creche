package model;

public class Endereco {
    private String rua;
    private String bairro;
    private String numero;

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua == null || rua.trim().isEmpty()) {
            System.out.println("Digite novamente.");
        }
        if (!rua.matches("[A-Za-zÀ-ÿ ]+")) {
            throw new IllegalArgumentException("Digite apenas letras válidas.");
        } else {
            this.rua = rua;
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro == null || bairro.trim().isEmpty()) {
            System.out.println("O bairro não pode estar vazio.");
        }
        if (!bairro.matches("[A-Za-zÀ-ÿ ]+")) {
            throw new IllegalArgumentException("O bairro contém caracteres inválidos.");
        }
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            System.out.println("Digite novamente.");
        }
        if (!numero.matches("^\\d+$")) {
            throw new IllegalArgumentException("Digite apenas números válidos.");
        }
        this.numero = numero;
    }

    public String getEnderecoCompleto() {
        return rua + ", " + numero + " - " + bairro;
    }
}
