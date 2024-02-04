package br.com.feitoamaoapi.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.feitoamaoapi.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>, JpaSpecificationExecutor<Vendedor> {
	static Specification<Vendedor> hasNomeVendedor(String nomeVendedor) {
		return (root, query, criteriaBuilder) -> {
			if (nomeVendedor == null || nomeVendedor.isEmpty()) {
				return criteriaBuilder.conjunction();
			} else {
				return criteriaBuilder.like(criteriaBuilder.lower(root.get("usuario").get("nome")),
						("%" + nomeVendedor + "%").toLowerCase());
			}
		};
	}
}
