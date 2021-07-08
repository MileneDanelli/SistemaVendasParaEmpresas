package prova_4.vendas_empresas.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prova_4.vendas_empresas.dtos.EmpresaDTO;
import prova_4.vendas_empresas.dtos.NovaEmpresaDTO;
import prova_4.vendas_empresas.dtos.NovoProdutoDTO;
import prova_4.vendas_empresas.dtos.ProdutoDTO;
import prova_4.vendas_empresas.models.Empresa;
import prova_4.vendas_empresas.models.Produto;
import prova_4.vendas_empresas.services.EmpresaService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/empresas"})
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<EmpresaDTO> visualizar(){
        return empresaService.VisualizarEmpresa()
                .stream()
                .map(this::toEmpresaDTO)
                .collect(Collectors.toList());
    }

    private EmpresaDTO toEmpresaDTO(Empresa empresa){
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa cadastrar(@Valid @RequestBody NovaEmpresaDTO empresa){
        return empresaService.CadastrarEmpresa(empresa.converteModelo());
    }
}
