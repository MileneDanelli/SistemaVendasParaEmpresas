package prova_4.vendas_empresas.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prova_4.vendas_empresas.dtos.ProdutoDTO;
import prova_4.vendas_empresas.models.Empresa;
import prova_4.vendas_empresas.models.Produto;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Produto.class, ProdutoDTO.class)
                .<Empresa>addMapping(src -> src.getEmpresa(),
                        (dest, value) -> dest.setEmpresa(value));
        return modelMapper;
    }
}
