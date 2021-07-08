package prova_4.vendas_empresas.dtos;

import lombok.Data;
import prova_4.vendas_empresas.models.Empresa;
import prova_4.vendas_empresas.models.Produto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class NovoProdutoDTO {
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public Produto converteModelo(){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setEmpresa(empresa);
        return produto;
    }
}
