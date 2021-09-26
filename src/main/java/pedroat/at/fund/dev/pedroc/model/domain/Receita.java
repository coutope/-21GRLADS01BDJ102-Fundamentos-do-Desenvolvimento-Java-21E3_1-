package pedroat.at.fund.dev.pedroc.model.domain;

import pedroat.at.fund.dev.pedroc.model.exception.FonteVaziaInvalidaException;

public class Receita extends Categoria {
    private String fonte;
    private int opcaoRecorrencia;
    private String recorrencia;

    public Receita(String dataVencimento, String nome, String comentario, String categoria, boolean recorrente, float valor, String tipo) {
        super(dataVencimento, nome, comentario, categoria, recorrente, valor, tipo);
    }


    @Override
    public String determinaRecorrencia() {
        if(isRecorrente() == false || opcaoRecorrencia == 0 || opcaoRecorrencia >2){
            setRecorrencia("Lançamento Único");
        }else if(opcaoRecorrencia == 1){
            setRecorrencia("Lançamento Quinzenal");
        }else if(opcaoRecorrencia == 2){
            setRecorrencia("Lançamento Mensal");
        }
        return getRecorrencia();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(fonte);
        sb.append(";");
        sb.append(opcaoRecorrencia);
        sb.append(";");
        sb.append(determinaRecorrencia());
        sb.append(";");

        return sb.toString();
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) throws FonteVaziaInvalidaException{
        if(fonte == ""){
            throw new FonteVaziaInvalidaException("O campo Fonte precisa ser preenchido.");
        }
        this.fonte = fonte;
    }

    public String getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }

    public int getOpcaoRecorrencia() {
        return opcaoRecorrencia;
    }

    public void setOpcaoRecorrencia(int opcaoRecorrencia) {
        this.opcaoRecorrencia = opcaoRecorrencia;
    }
}
