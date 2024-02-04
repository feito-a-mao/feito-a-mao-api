package br.com.feitoamaoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import br.com.feitoamaoapi.dto.VendedorDTO;
import br.com.feitoamaoapi.dto.VendedorParameters;
import br.com.feitoamaoapi.entity.Vendedor;
import br.com.feitoamaoapi.infra.dto.BaseDTO;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;
import br.com.feitoamaoapi.infra.service.AbstractCrudService;
import br.com.feitoamaoapi.mapper.VendedorMapper;
import br.com.feitoamaoapi.repository.VendedorRepository;

@Service
public class VendedorServiceImpl extends AbstractCrudService<Vendedor, VendedorDTO> implements VendedorService {

	private final VendedorRepository vendedorRepository;

	@Autowired
	public VendedorServiceImpl(final VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}

	@Override
	public PaginaDTO<VendedorDTO> recuperarTodos(VendedorParameters parameters, Integer offset, Integer limit,
			String sort) {
		return super.recuperarTodos(parameters, offset, limit, sort);
	}

	@Override
	protected JpaSpecificationExecutor<Vendedor> getSpecificationExecutor() {
		return vendedorRepository;
	}

	@Override
	protected VendedorDTO mapEntityToDTO(Vendedor entity) {
		return VendedorMapper.fromEntityToDTO(entity);
	}

	@Override
	protected Specification<Vendedor> buildSpecification(BaseDTO baseDTO) {
		VendedorParameters params = (VendedorParameters) baseDTO;
		return Specification.where(VendedorRepository.hasNomeVendedor(params.getNomeVendedor()));
	}

}
