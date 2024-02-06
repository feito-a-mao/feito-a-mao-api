package br.com.feitoamaoapi.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import br.com.feitoamaoapi.entity.Produto;

public class ProdutoRepositoryTest {

	@Mock
	private CriteriaBuilder criteriaBuilder;

	@Mock
	private Root<Produto> produtoRoot;

	@Mock
	private CriteriaQuery<Produto> criteriaQuery;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testHasNomeProduto() {
		String nomeProduto = "nomeProduto";
		Specification<Produto> specification = ProdutoRepository.hasNomeProduto(nomeProduto);

		when(criteriaBuilder.like(any(), any(String.class))).thenReturn(null);
		when(criteriaBuilder.conjunction()).thenReturn(null);

		specification.toPredicate(produtoRoot, criteriaQuery, criteriaBuilder);

		Assert.assertNotNull(specification);
	}

	@Test
	public void testHasNomeProdutoNull() {
		String nomeProduto = null;
		Specification<Produto> specification = ProdutoRepository.hasNomeProduto(nomeProduto);

		when(criteriaBuilder.like(any(), any(String.class))).thenReturn(null);
		when(criteriaBuilder.conjunction()).thenReturn(null);

		specification.toPredicate(produtoRoot, criteriaQuery, criteriaBuilder);

		Assert.assertNotNull(specification);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testHasNomeVendedor() {
		String nomeVendedor = "John Doe";
		Specification<Produto> specification = ProdutoRepository.hasNomeVendedor(nomeVendedor);

		// Mock behavior for root.get("vendedor").get("usuario").get("nome")
		Path<Object> vendedorPath = mock(Path.class);
		Path<Object> usuarioPath = mock(Path.class);
		Path<Object> nomePath = mock(Path.class);
		Expression<String> expression = mock(Expression.class);
		when(produtoRoot.get("vendedor")).thenReturn(vendedorPath);
		when(vendedorPath.get("usuario")).thenReturn(usuarioPath);
		when(usuarioPath.get("nome")).thenReturn(nomePath);

		when(criteriaBuilder.lower(any())).thenReturn(expression);

		when(criteriaBuilder.like(any(Expression.class), any(String.class))).thenReturn(null);

		specification.toPredicate(produtoRoot, criteriaQuery, criteriaBuilder);

		Assert.assertNotNull(specification);
	}

	@Test
	public void testHasNomeVendedorNull() {
		String nomeVendedor = null;
		Specification<Produto> specification = ProdutoRepository.hasNomeVendedor(nomeVendedor);

		when(criteriaBuilder.conjunction()).thenReturn(null);

		specification.toPredicate(produtoRoot, criteriaQuery, criteriaBuilder);

		Assert.assertNotNull(specification);
	}

}
