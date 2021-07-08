package prova_4.vendas_empresas.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import prova_4.vendas_empresas.dtos.NovoProdutoDTO;
import prova_4.vendas_empresas.dtos.ProdutoDTO;
import prova_4.vendas_empresas.models.Produto;
import prova_4.vendas_empresas.services.ProdutoService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/produtos"})
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ProdutoDTO> visualizar(){
        return produtoService.VisualizarProduto()
                .stream()
                .map(this::toProdutoDTO)
                .collect(Collectors.toList());
    }

    private ProdutoDTO toProdutoDTO(Produto produto){
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar(@Valid @RequestBody NovoProdutoDTO produto){
        return produtoService.CadastrarProduto(produto.converteModelo());
    }
}
