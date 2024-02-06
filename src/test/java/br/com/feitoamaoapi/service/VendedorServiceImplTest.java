package br.com.feitoamaoapi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.feitoamaoapi.dto.VendedorDTO;
import br.com.feitoamaoapi.dto.VendedorParameters;
import br.com.feitoamaoapi.entity.Vendedor;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;
import br.com.feitoamaoapi.repository.VendedorRepository;

public class VendedorServiceImplTest {

	@InjectMocks
	private VendedorServiceImpl vendedorService;

	@Mock
	private VendedorRepository vendedorRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos() {
		VendedorParameters parameters = new VendedorParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "descricao,asc";

		List<Vendedor> vendedorList = new ArrayList<>();
		vendedorList.add(new Vendedor());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Vendedor> pageVendedor = new PageImpl<>(vendedorList, pageable, vendedorList.size());

		when(vendedorRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageVendedor);

		PaginaDTO<VendedorDTO> result = vendedorService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(vendedorList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(vendedorList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_OrdenacaoNull() {
		VendedorParameters parameters = new VendedorParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = null;

		List<Vendedor> vendedorList = new ArrayList<>();
		vendedorList.add(new Vendedor());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Vendedor> pageVendedor = new PageImpl<>(vendedorList, pageable, vendedorList.size());

		when(vendedorRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageVendedor);

		PaginaDTO<VendedorDTO> result = vendedorService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(vendedorList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(vendedorList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_OrdenacaoEmpty() {
		VendedorParameters parameters = new VendedorParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "descricao,desc";

		List<Vendedor> vendedorList = new ArrayList<>();
		vendedorList.add(new Vendedor());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Vendedor> pageVendedor = new PageImpl<>(vendedorList, pageable, vendedorList.size());

		when(vendedorRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageVendedor);

		PaginaDTO<VendedorDTO> result = vendedorService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(vendedorList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(vendedorList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_OrdenacaoDesc() {
		VendedorParameters parameters = new VendedorParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "";

		List<Vendedor> vendedorList = new ArrayList<>();
		vendedorList.add(new Vendedor());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Vendedor> pageVendedor = new PageImpl<>(vendedorList, pageable, vendedorList.size());

		when(vendedorRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageVendedor);

		PaginaDTO<VendedorDTO> result = vendedorService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(vendedorList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(vendedorList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_OrdenacaoLength() {
		VendedorParameters parameters = new VendedorParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "descricao";

		List<Vendedor> vendedorList = new ArrayList<>();
		vendedorList.add(new Vendedor());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Vendedor> pageVendedor = new PageImpl<>(vendedorList, pageable, vendedorList.size());

		when(vendedorRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageVendedor);

		PaginaDTO<VendedorDTO> result = vendedorService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(vendedorList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(vendedorList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_WithEmptyList() {
		VendedorParameters parameters = new VendedorParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "descricao,asc";

		List<Vendedor> vendedorList = new ArrayList<>();

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Vendedor> pageVendedor = new PageImpl<>(vendedorList, pageable, vendedorList.size());

		when(vendedorRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageVendedor);

		PaginaDTO<VendedorDTO> result = vendedorService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(vendedorList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(vendedorList.size(), result.getItens().size());
	}

}
