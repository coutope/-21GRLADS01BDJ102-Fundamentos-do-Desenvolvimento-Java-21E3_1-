package pedroat.at.fund.dev.pedroc.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Financa {
    private LocalDateTime data;
    private Cliente usuario;
    private String descricao;
    private List<Categoria> categorias;
    private boolean planejado;

    public Financa() {
        data = LocalDateTime.now();
    }

    public Financa(LocalDateTime data, Cliente usuario, String descricao, List<Categoria> categorias, boolean planejado) {
        this.data = data;
        this.usuario = usuario;
        this.descricao = descricao;
        this.categorias = categorias;
        this.planejado = planejado;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringBuilder sb = new StringBuilder();


        sb.append(data.format(formato));
        sb.append(";");
        sb.append(descricao);
        sb.append(";");
        sb.append(planejado);
        sb.append(";");
        sb.append(usuario);

        if(categorias != null){
            sb.append(";");
            sb.append(categorias.size());
        }
        return sb.toString();
    }

    public LocalDateTime getData() {
        return data;
    }

    public Cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public boolean isPlanejado() {
        return planejado;
    }

    public void setPlanejado(boolean planejado) {
        this.planejado = planejado;
    }
}
