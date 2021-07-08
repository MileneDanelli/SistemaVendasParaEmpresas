package prova_4.vendas_empresas.excessoes;

public class RecursoNaoEncontrado extends RuntimeException {

    public RecursoNaoEncontrado(String msg) {
        super(msg);
    }

    public RecursoNaoEncontrado() {
        super("Recurso não Encontrado!");
    }
}
