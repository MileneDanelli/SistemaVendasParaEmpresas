package prova_4.vendas_empresas.dtos;

import lombok.Data;
import prova_4.vendas_empresas.models.Empresa;

@Data
public class NovaEmpresaDTO {
    private String nome;
    private String cnpj;

    public Empresa converteModelo(){
        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        empresa.setCnpj(cnpj);
        return empresa;
    }
}
