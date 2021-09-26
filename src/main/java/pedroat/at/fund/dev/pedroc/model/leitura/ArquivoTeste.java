package pedroat.at.fund.dev.pedroc.model.leitura;


import pedroat.at.fund.dev.pedroc.model.domain.*;
import pedroat.at.fund.dev.pedroc.model.exception.BeneficiarioVazioException;
import pedroat.at.fund.dev.pedroc.model.exception.FonteVaziaInvalidaException;
import pedroat.at.fund.dev.pedroc.model.exception.ObjetivoVazioInvalido;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTeste {

    public static void main(String[] args) {

        String dir = "C:\\dev/";
        String arq = "Financas.txt";

        try {

            try {
                FileReader file = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(file);

                FileWriter fileW = new FileWriter(dir + "out_" + arq);
                BufferedWriter escrita = new BufferedWriter(fileW);

                String linha = null;
                String[] campos;

                linha = leitura.readLine();
                List<Categoria> categorias = new ArrayList<Categoria>();
                Financa financa = new Financa();

                while (linha != null) {

                    campos = linha.split(";");

                    if (campos.length == 6) {
                        Cliente usuario = new Cliente(campos[3], campos[4], campos[5]);


                        financa.getData();
                        financa.setUsuario(usuario);
                        financa.setDescricao(campos[1]);
                        financa.setPlanejado(Boolean.valueOf(campos[2]));


                    } else {

                        switch (campos[0]) {
                            case "R":
                                Receita ativo = new Receita(
                                        campos[1],
                                        campos[2],
                                        campos[3],
                                        campos[4],
                                        Boolean.valueOf(campos[5]),
                                        Float.valueOf(campos[6]),
                                        campos[7]);
                                ativo.setFonte(campos[8]);
                                ativo.setOpcaoRecorrencia(Integer.valueOf(campos[9]));
                                ativo.setRecorrencia(campos[10]);
                                categorias.add(ativo);
                                break;

                            case "D":
                                Despesa passivo = new Despesa(
                                        campos[1],
                                        campos[2],
                                        campos[3],
                                        campos[4],
                                        Boolean.valueOf(campos[5]),
                                        Float.valueOf(campos[6]),
                                        campos[7]);
                                passivo.setBeneficiario(campos[8]);
                                passivo.setOpcaoRecorrencia(Integer.valueOf(campos[9]));
                                passivo.setRecorrencia(campos[10]);
                                categorias.add(passivo);
                                break;

                            case "O":
                                Objetivo economia = new Objetivo(
                                        campos[1],
                                        campos[2],
                                        campos[3],
                                        campos[4],
                                        Boolean.valueOf(campos[5]),
                                        Float.valueOf(campos[6]),
                                        campos[7]);
                                economia.setObjetivo(campos[8]);
                                economia.setOpcaoRecorrencia(Integer.valueOf(campos[9]));
                                economia.setRecorrencia(campos[10]);
                                categorias.add(economia);
                                break;

                            default:
                                System.out.println("nao tem lancamento valido...");
                                break;
                        }
                    }

                    linha = leitura.readLine();

                }
                financa.setCategorias(categorias);

                for (Categoria cat : financa.getCategorias()) {
                    escrita.write(
                            financa.getDescricao() + ";" +
                                    financa.getUsuario().getNome() + ";" +
                                    cat.getNome() + ";" +
                                    cat.getValor() + ";" +
                                    cat.determinaRecorrencia() + "\r\n");
                }


                leitura.close();
                file.close();

                escrita.close();
                fileW.close();
            } catch (IOException | FonteVaziaInvalidaException | BeneficiarioVazioException | ObjetivoVazioInvalido e) {
                System.out.println(e.getMessage());
            }

        } finally {
            System.out.println("Processamento realizado...");
        }
    }
}
