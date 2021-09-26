package pedroat.at.fund.dev.pedroc.model.domain;


import pedroat.at.fund.dev.pedroc.model.exception.ObjetivoVazioInvalido;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Objetivo extends Categoria {
    private String objetivo;
    private int opcaoRecorrencia;
    private String recorrencia;

    public Objetivo(String data, String nome, String comentario, String categoria, boolean recorrente, float valor, String tipo) {
        super(data, nome, comentario, categoria, recorrente, valor, tipo);
    }

    @Override
    public String determinaRecorrencia() {
        if(isRecorrente() == false || opcaoRecorrencia == 0 ||opcaoRecorrencia >2){
            setRecorrencia("Depósito Único");
        }else if(opcaoRecorrencia == 1){
            setRecorrencia("Depósito Mensal");
        }else if(opcaoRecorrencia == 2){
            setRecorrencia("Depósito Anual");
        }else{
            setRecorrencia("Depósito Único");
        }

        return getRecorrencia();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(objetivo);
        sb.append(";");
        sb.append(opcaoRecorrencia);
        sb.append(";");
        sb.append(determinaRecorrencia());
        sb.append(";");
        return sb.toString();
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) throws ObjetivoVazioInvalido {
        if (objetivo == ""){
            throw new ObjetivoVazioInvalido("O campo Objetivo deve ser informado!!");
        }
        this.objetivo = objetivo;
    }

    public int getOpcaoRecorrencia() {
        return opcaoRecorrencia;
    }

    public void setOpcaoRecorrencia(int opcaoRecorrencia) {
        this.opcaoRecorrencia = opcaoRecorrencia;
    }

    public String getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }
}