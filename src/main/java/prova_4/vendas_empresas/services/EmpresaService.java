package prova_4.vendas_empresas.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prova_4.vendas_empresas.models.Empresa;
import prova_4.vendas_empresas.repositories.EmpresaRepositorio;

import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    private final EmpresaRepositorio empresaRepositorio;

    public EmpresaService(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }
    public List<Empresa> VisualizarEmpresa(){
        return empresaRepositorio.findAll();
    }

    public Empresa CadastrarEmpresa(Empresa empresa) {
        return empresaRepositorio.save(empresa);
    }
}
