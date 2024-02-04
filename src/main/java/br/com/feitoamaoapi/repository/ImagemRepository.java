package br.com.feitoamaoapi.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.feitoamaoapi.entity.Imagem;
import br.com.feitoamaoapi.entity.ImagemProduto;

public interface ImagemRepository extends JpaRepository<Imagem, Long>, JpaSpecificationExecutor<Imagem> {
	public static Specification<Imagem> hasIdProduto(Long idProduto) {
		return (Root<Imagem> imagemRoot, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			if (idProduto == null) {
				return criteriaBuilder.conjunction();
			} else {
				Subquery<Long> subquery = query.subquery(Long.class);
				Root<ImagemProduto> imagemProdutoRoot = subquery.from(ImagemProduto.class);
				subquery.select(imagemProdutoRoot.get("idImagem"));
				Predicate predicate = criteriaBuilder.equal(imagemProdutoRoot.get("idProduto"), idProduto);
				subquery.where(predicate);

				return imagemRoot.get("id").in(subquery);
			}
		};
	}
}
