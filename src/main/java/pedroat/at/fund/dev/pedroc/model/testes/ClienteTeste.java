package pedroat.at.fund.dev.pedroc.model.testes;

import pedroat.at.fund.dev.pedroc.model.domain.Cliente;

public class ClienteTeste {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Evan", "123456789-10", "evan@evan.com.br");
        System.out.println(cliente);
    }
}
