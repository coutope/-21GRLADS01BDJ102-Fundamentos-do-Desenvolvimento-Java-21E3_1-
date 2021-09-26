package pedroat.at.fund.dev.pedroc.model.testes;


import pedroat.at.fund.dev.pedroc.model.domain.*;
import pedroat.at.fund.dev.pedroc.model.exception.BeneficiarioVazioException;
import pedroat.at.fund.dev.pedroc.model.exception.FonteVaziaInvalidaException;
import pedroat.at.fund.dev.pedroc.model.exception.ObjetivoVazioInvalido;

import java.util.ArrayList;
import java.util.List;

public class FinancaTeste {
    public static void main(String[] args) {
        Cliente usuario = new Cliente("Evan", "123456789-10", "evan@rispoli.com.br");


        Receita presente = new Receita(
                "05/10/2021",
                "Satisfatorio",
                "Presente",
                "Renda extra",
                true,
                100,
                "Desejado");
        try {
            presente.setFonte("Prof. Elberth");
        } catch (FonteVaziaInvalidaException e) {
            e.getMessage();
        }
        presente.setOpcaoRecorrencia(0);



        Despesa luz = new Despesa(
                "15/10/2021",
                "Conta de luz",
                "Energia Elétrica",
                "Moradia",
                true,
                500,
                "Necessário");
        try {
            luz.setBeneficiario("LIGHT");
        } catch (BeneficiarioVazioException e) {
            e.getMessage();
        }
        luz.setOpcaoRecorrencia(2);


        Despesa agua = new Despesa(
                "15/10/2021",
                "Conta de Agua",
                "Consumo de agua",
                "Moradia",
                true,
                200,
                "Necessário");
        try {
            agua.setBeneficiario("CEDAE");
        } catch (BeneficiarioVazioException e) {
            e.getMessage();
        }
        luz.setOpcaoRecorrencia(2);

        Objetivo ferias = new Objetivo(
                "30/10/2021",
                "Vai que...",
                "Conta Poupança",
                "Economias",
                true,
                500,
                "Desejável");
        try {
            ferias.setObjetivo("");
        } catch (ObjetivoVazioInvalido e) {
            e.getMessage();
        }
        ferias.setOpcaoRecorrencia(1);




        List<Categoria> listaMoradia = new ArrayList<Categoria>();
        listaMoradia.add(luz);
        listaMoradia.add(agua);

        List<Categoria>listaLazer = new ArrayList<Categoria>();
        listaLazer.add(ferias);


        Financa moradia = new Financa();
        moradia.getData();
        moradia.setCategorias(listaMoradia);
        moradia.setUsuario(usuario);
        moradia.setDescricao("Contas essenciais");
        moradia.setPlanejado(true);

        System.out.println(moradia);

        Financa lazer = new Financa();
        lazer.getData();
        lazer.setCategorias(listaLazer);
        lazer.setUsuario(usuario);
        lazer.setDescricao("Atividades de lazer");
        lazer.setPlanejado(true);

        System.out.println(lazer);


    }
}

