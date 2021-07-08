package prova_4.vendas_empresas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prova_4.vendas_empresas.models.Empresa;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {
}
