package prova_4.vendas_empresas.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prova_4.vendas_empresas.excessoes.RecursoNaoEncontrado;
import prova_4.vendas_empresas.models.Produto;
import prova_4.vendas_empresas.repositories.EmpresaRepositorio;
import prova_4.vendas_empresas.repositories.ProdutoRepositorio;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private final ProdutoRepositorio produtoRepositorio;

    @Autowired
    private final EmpresaRepositorio empresaRepositorio;

    public ProdutoService(ProdutoRepositorio produtoRepositorio, EmpresaRepositorio empresaRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
        this.empresaRepositorio = empresaRepositorio;
    }
    public List<Produto> VisualizarProduto(){
        return produtoRepositorio.findAll();
    }

    public Produto CadastrarProduto(Produto produto) {
        Integer id_empresa = produto.getEmpresa().getId();

        var empresa = empresaRepositorio.findById(id_empresa)
                .orElseThrow(
                        () -> new RecursoNaoEncontrado("Empresa não Encontrada! id:" + id_empresa)
                );
        produto.setEmpresa(empresa);

        return produtoRepositorio.save(produto);
    }
}
