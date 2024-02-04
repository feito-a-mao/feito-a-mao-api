package br.com.feitoamaoapi.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.feitoamaoapi.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {
	static Specification<Produto> hasNomeVendedor(String nomeVendedor) {
		return (root, query, criteriaBuilder) -> {
			if (nomeVendedor == null || nomeVendedor.isEmpty()) {
				return criteriaBuilder.conjunction();
			} else {
				return criteriaBuilder.like(criteriaBuilder.lower(root.get("vendedor").get("usuario").get("nome")),
						("%" + nomeVendedor + "%").toLowerCase());
			}
		};
	}

	static Specification<Produto> hasNomeProduto(String nomeProduto) {
		return (root, query, criteriaBuilder) -> {
			if (nomeProduto == null || nomeProduto.isEmpty()) {
				return criteriaBuilder.conjunction();
			} else {
				return criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")),
						("%" + nomeProduto + "%").toLowerCase());
			}
		};
	}
}
