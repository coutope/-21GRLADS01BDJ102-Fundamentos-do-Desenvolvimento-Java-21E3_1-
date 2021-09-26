package pedroat.at.fund.dev.pedroc.model.domain;

import pedroat.at.fund.dev.pedroc.model.exception.BeneficiarioVazioException;

public class Despesa extends Categoria {
    private String beneficiario;
    private int opcaoRecorrencia;
    private String recorrencia;

    public Despesa(String data, String nome, String descricao, String categoria, boolean recorrente, float valor, String tipo) {
        super(data, nome, descricao, categoria, recorrente, valor, tipo);
    }

    @Override
    public String determinaRecorrencia() {
        if(isRecorrente() == false || opcaoRecorrencia == 0 ||opcaoRecorrencia >5){
            setRecorrencia("Lançamento Único");
        }else if(opcaoRecorrencia == 1){
            setRecorrencia("Lançamento Quinzenal");
        }else if(opcaoRecorrencia == 2){
            setRecorrencia("Lançamento Mensal");
        }else if(opcaoRecorrencia == 3) {
            setRecorrencia("Lançamento Trimestral");
        }else if(opcaoRecorrencia == 4) {
            setRecorrencia("Lançamento Semestral");
        }else if(opcaoRecorrencia == 5) {
            setRecorrencia("Lançamento Anual");
        }
        else{
            setRecorrencia("Lançamento Único");
        }

        return getRecorrencia();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(beneficiario);
        sb.append(";");
        sb.append(opcaoRecorrencia);
        sb.append(";");
        sb.append(determinaRecorrencia());
        return sb.toString();
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) throws BeneficiarioVazioException {
        if(beneficiario == ""){
            throw new BeneficiarioVazioException("O campo Beneficiario precisa ser preenchido");
        }
        this.beneficiario = beneficiario;
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
