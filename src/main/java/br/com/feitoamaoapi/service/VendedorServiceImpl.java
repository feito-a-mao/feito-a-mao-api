package br.com.feitoamaoapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.feitoamaoapi.dto.VendedorDTO;
import br.com.feitoamaoapi.entity.Vendedor;
import br.com.feitoamaoapi.mapper.VendedorMapper;
import br.com.feitoamaoapi.repository.VendedorRepository;

@Service
public class VendedorServiceImpl implements VendedorService {

	private final VendedorRepository vendedorRepository;

	@Autowired
	public VendedorServiceImpl(final VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}

	@Override
	public List<VendedorDTO> listar() {
		List<Vendedor> entities = vendedorRepository.findAll();
		return entities.stream().map(VendedorMapper::fromEntityToDTO).collect(Collectors.toList());
	}
}
