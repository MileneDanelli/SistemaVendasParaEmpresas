package prova_4.vendas_empresas.dtos;

import lombok.Data;
import prova_4.vendas_empresas.models.Empresa;

@Data
public class ProdutoDTO {
    private Integer id_produto;
    private String nome;
    private Empresa empresa;
}
