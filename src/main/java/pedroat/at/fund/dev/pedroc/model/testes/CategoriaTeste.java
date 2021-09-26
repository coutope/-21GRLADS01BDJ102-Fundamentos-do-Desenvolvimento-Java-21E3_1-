package pedroat.at.fund.dev.pedroc.model.testes;

import pedroat.at.fund.dev.pedroc.model.domain.Despesa;
import pedroat.at.fund.dev.pedroc.model.domain.Objetivo;
import pedroat.at.fund.dev.pedroc.model.domain.Receita;
import pedroat.at.fund.dev.pedroc.model.exception.BeneficiarioVazioException;
import pedroat.at.fund.dev.pedroc.model.exception.FonteVaziaInvalidaException;
import pedroat.at.fund.dev.pedroc.model.exception.ObjetivoVazioInvalido;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CategoriaTeste {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            Receita income1 = new Receita(
                    "01/10/2021",
                    "Pgt..",
                    "Sal..",
                    "Renda..",
                    true,
                    3525,
                    "Necessário");
            income1.setFonte("Instituição");
            income1.setOpcaoRecorrencia(1);
            System.out.println(income1);
        } catch (FonteVaziaInvalidaException e) {
            System.out.println(e.getMessage());
        }



        try {
       Receita income2 = new Receita(
                "05/10/2021",
                "Comissão",
                "Salário",
                "Renda Complementar",
                true,
                3525,
                "Desejado");
        income2.setFonte("Loja ABC");
        income2.setOpcaoRecorrencia(2);
        System.out.println(income2.determinaRecorrencia());
        } catch (FonteVaziaInvalidaException e) {
            System.out.println(e.getMessage());
        }

        try {
            Receita income3 = new Receita(
                    "05/10/2021",
                    "Deu bom",
                    "Presente",
                    "Renda extra",
                    true,
                    100,
                    "Desejado");
            income3.setFonte("");
            income3.setOpcaoRecorrencia(0);
            System.out.println(income3);
        } catch (FonteVaziaInvalidaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------------------");

        try {
            Despesa outgoing1 = new Despesa(
                    "15/10/2021",
                    "Conta de luz",
                    "Energia Elétrica",
                    "Moradia",
                    true,
                    500,
                    "Necessário");
            outgoing1.setBeneficiario("LIGHT");
            outgoing1.setOpcaoRecorrencia(2);
            System.out.println(outgoing1);
        }catch (BeneficiarioVazioException e){
            System.out.println(e.getMessage());
        }

        try {

        Despesa outgoing2 = new Despesa(
                "20/10/2021",
                "Conta de Telefone",
                "Telefone",
                "Moradia",
                true,
                150,
                "Necessário");
        outgoing2.setBeneficiario("VIVO");
        outgoing2.setOpcaoRecorrencia(2);
        System.out.println(outgoing2.determinaRecorrencia());
        }catch (BeneficiarioVazioException e){
            System.out.println(e.getMessage());
        }


        try {
        Despesa outgoing3 = new Despesa(
                "25/10/2021",
                "RENAVAM",
                "IPVA",
                "Transporte",
                true,
                2500,
                "Necessário");
        outgoing3.setBeneficiario("");
        outgoing3.setOpcaoRecorrencia(5);
        System.out.println(outgoing3);
        }catch (BeneficiarioVazioException e){
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------------------");



        try {
            Objetivo saving1 = new Objetivo(
                    "30/10/2021",
                    "Canadá 2022",
                    "Conta Poupança",
                    "Economias",
                    true,
                    500,
                    "Desejável");
            saving1.setObjetivo("Férias");
            saving1.setOpcaoRecorrencia(1);
            System.out.println(saving1);
        } catch (ObjetivoVazioInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Objetivo saving2 = new Objetivo(
                    "30/10/2021",
                    "Maricá",
                    "Conta Poupança",
                    "Economias",
                    true,
                    10000,
                    "Desejável");
            saving2.setObjetivo("Férias 2022");
            saving2.setOpcaoRecorrencia(2);
            System.out.println(saving2.determinaRecorrencia());
        } catch (ObjetivoVazioInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Objetivo saving3 = new Objetivo(
                    "30/10/2021",
                    "Turbo",
                    "Carro Novo",
                    "Economias",
                    true,
                    50000,
                    "Desejável");

            saving3.setObjetivo("");
            saving3.setOpcaoRecorrencia(1);
            System.out.println(saving3);
        } catch (ObjetivoVazioInvalido e) {
            System.out.println(e.getMessage());
        }
        System.out.println("------------------------------------------");





        //para cada tipo de categoria faça duas instâncias...
        // uma dando um sout no objeto e outro exibindo o método abstrato


    }
}
