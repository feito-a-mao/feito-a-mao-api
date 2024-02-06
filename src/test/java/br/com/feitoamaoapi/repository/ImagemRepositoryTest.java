package br.com.feitoamaoapi.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import br.com.feitoamaoapi.entity.Imagem;
import br.com.feitoamaoapi.entity.ImagemProduto;

public class ImagemRepositoryTest {

	@Mock
	private CriteriaBuilder criteriaBuilder;

	@Mock
	private Root<Imagem> imagemRoot;

	@Mock
	private CriteriaQuery<?> criteriaQuery;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testHasIdProduto() {
		Long idProduto = 1L;
		Specification<Imagem> specification = ImagemRepository.hasIdProduto(idProduto);

		Subquery<Long> subquery = mock(Subquery.class);
		Root<ImagemProduto> imagemProdutoRoot = mock(Root.class);

		when(criteriaQuery.subquery(Long.class)).thenReturn(subquery);
		when(subquery.from(ImagemProduto.class)).thenReturn(imagemProdutoRoot);
		when(imagemProdutoRoot.get("idImagem")).thenReturn(null);
		when(imagemProdutoRoot.get("idProduto")).thenReturn(null);
		when(criteriaBuilder.equal(any(), any())).thenReturn(null);

		Path<Object> idPath = mock(Path.class);
		when(imagemRoot.get("id")).thenReturn(idPath);
		when(idPath.in(subquery)).thenReturn(null);

		specification.toPredicate(imagemRoot, criteriaQuery, criteriaBuilder);

		Assert.assertNotNull(specification);
	}

	@Test
	public void testHasIdProdutoNull() {
		Long idProduto = null;
		Specification<Imagem> specification = ImagemRepository.hasIdProduto(idProduto);

		when(criteriaBuilder.conjunction()).thenReturn(null);

		specification.toPredicate(imagemRoot, criteriaQuery, criteriaBuilder);

		Assert.assertNotNull(specification);
	}
}
