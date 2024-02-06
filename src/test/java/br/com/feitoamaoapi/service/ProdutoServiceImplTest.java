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

import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.dto.ProdutoParameters;
import br.com.feitoamaoapi.entity.Produto;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;
import br.com.feitoamaoapi.repository.ProdutoRepository;

public class ProdutoServiceImplTest {

	@InjectMocks
	private ProdutoServiceImpl produtoService;

	@Mock
	private ProdutoRepository produtoRepository;

	@Mock
	private ImagemProdutoService imagemProdutoService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos() {
		ProdutoParameters parameters = new ProdutoParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "descricao,asc";

		List<Produto> produtoList = new ArrayList<>();
		produtoList.add(new Produto());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Produto> pageProduto = new PageImpl<>(produtoList, pageable, produtoList.size());

		when(produtoRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageProduto);

		PaginaDTO<ProdutoDTO> result = produtoService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(produtoList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(produtoList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_OrdenacaoNull() {
		ProdutoParameters parameters = new ProdutoParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = null;

		List<Produto> produtoList = new ArrayList<>();
		produtoList.add(new Produto());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Produto> pageProduto = new PageImpl<>(produtoList, pageable, produtoList.size());

		when(produtoRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageProduto);

		PaginaDTO<ProdutoDTO> result = produtoService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(produtoList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(produtoList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_OrdenacaoEmpty() {
		ProdutoParameters parameters = new ProdutoParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "descricao,desc";

		List<Produto> produtoList = new ArrayList<>();
		produtoList.add(new Produto());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Produto> pageProduto = new PageImpl<>(produtoList, pageable, produtoList.size());

		when(produtoRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageProduto);

		PaginaDTO<ProdutoDTO> result = produtoService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(produtoList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(produtoList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_OrdenacaoDesc() {
		ProdutoParameters parameters = new ProdutoParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "";

		List<Produto> produtoList = new ArrayList<>();
		produtoList.add(new Produto());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Produto> pageProduto = new PageImpl<>(produtoList, pageable, produtoList.size());

		when(produtoRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageProduto);

		PaginaDTO<ProdutoDTO> result = produtoService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(produtoList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(produtoList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_OrdenacaoLength() {
		ProdutoParameters parameters = new ProdutoParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "descricao";

		List<Produto> produtoList = new ArrayList<>();
		produtoList.add(new Produto());

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Produto> pageProduto = new PageImpl<>(produtoList, pageable, produtoList.size());

		when(produtoRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageProduto);

		PaginaDTO<ProdutoDTO> result = produtoService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(produtoList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(produtoList.size(), result.getItens().size());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testRecuperarTodos_WithEmptyList() {
		ProdutoParameters parameters = new ProdutoParameters();
		Integer offset = 0;
		Integer limit = 10;
		String ordenacao = "descricao,asc";

		List<Produto> produtoList = new ArrayList<>();

		Pageable pageable = PageRequest.of(offset / limit, limit);
		Page<Produto> pageProduto = new PageImpl<>(produtoList, pageable, produtoList.size());

		when(produtoRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(pageProduto);

		PaginaDTO<ProdutoDTO> result = produtoService.recuperarTodos(parameters, offset, limit, ordenacao);

		Assert.assertNotNull(result);
		Assert.assertEquals(new Long(produtoList.size()), result.getTotalItens());
		Assert.assertEquals(new Integer(0), result.getCurrentPage());
		Assert.assertEquals(produtoList.size(), result.getItens().size());
	}

	@Test
	public void testSalvar() {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setDescricao("teste");

		Produto entity = new Produto();
		entity.setId(1L);
		entity.setDescricao(dto.getDescricao());
		when(produtoRepository.save(any(Produto.class))).thenReturn(entity);

		ProdutoDTO newDTO = new ProdutoDTO();
		newDTO.setId(entity.getId());
		newDTO.setDescricao(entity.getDescricao());

		ProdutoDTO resultDTO = produtoService.salvar(dto);

		Assert.assertNotNull(resultDTO);
		Assert.assertEquals(entity.getId(), resultDTO.getId());
		Assert.assertEquals(entity.getDescricao(), resultDTO.getDescricao());
	}

}
