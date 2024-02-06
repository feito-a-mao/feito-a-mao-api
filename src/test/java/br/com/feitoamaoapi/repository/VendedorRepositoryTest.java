package br.com.feitoamaoapi.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import br.com.feitoamaoapi.entity.Vendedor;

public class VendedorRepositoryTest {

	@Mock
	private CriteriaBuilder criteriaBuilder;

	@Mock
	private Root<Vendedor> vendedorRoot;

	@Mock
	private CriteriaQuery<Vendedor> criteriaQuery;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testHasNomeVendedor() {
		String nomeVendedor = "nomeVendedor";
		Specification<Vendedor> specification = VendedorRepository.hasNomeVendedor(nomeVendedor);

		Path<Object> usuarioPath = mock(Path.class);
		Path<Object> nomePath = mock(Path.class);
		when(vendedorRoot.get("usuario")).thenReturn(usuarioPath);
		when(usuarioPath.get("nome")).thenReturn(nomePath);

		when(criteriaBuilder.like(any(), any(String.class))).thenReturn(null);
		when(criteriaBuilder.conjunction()).thenReturn(null);

		specification.toPredicate(vendedorRoot, criteriaQuery, criteriaBuilder);

		Assert.assertNotNull(specification);
	}

	@Test
	public void testHasNomeVendedorNull() {
		String nomeVendedor = null;
		Specification<Vendedor> specification = VendedorRepository.hasNomeVendedor(nomeVendedor);

		when(criteriaBuilder.like(any(), any(String.class))).thenReturn(null);
		when(criteriaBuilder.conjunction()).thenReturn(null);

		specification.toPredicate(vendedorRoot, criteriaQuery, criteriaBuilder);

		Assert.assertNotNull(specification);
	}

}
