package pedroat.at.fund.dev.pedroc.model.domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Categoria {
    private String dataVencimento;
    private String nome;
    private String comentario;
    private String categoria;
    private boolean recorrente;
    private float valor;
    private String tipo;

    public abstract String determinaRecorrencia();

    public Categoria() {
    }

    public Categoria(String dataVencimento, String nome, String comentario, String categoria, boolean recorrente, float valor, String tipo) {
        this.dataVencimento = dataVencimento;
        this.nome = nome;
        this.comentario = comentario;
        this.categoria = categoria;
        this.recorrente = recorrente;
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringBuilder sb = new StringBuilder();
        sb.append(dataVencimento);
        sb.append(";");
        sb.append(nome);
        sb.append(";");
        sb.append(comentario);
        sb.append(";");
        sb.append(categoria);
        sb.append(";");
        sb.append(recorrente);
        sb.append(";");
        sb.append(valor);
        sb.append(";");
        sb.append(tipo);
        sb.append(";");
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getComentarios() {
        return comentario;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public float getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}