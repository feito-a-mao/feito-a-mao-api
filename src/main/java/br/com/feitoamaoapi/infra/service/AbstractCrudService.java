package br.com.feitoamaoapi.infra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.feitoamaoapi.infra.dto.BaseDTO;
import br.com.feitoamaoapi.infra.dto.PaginaDTO;

/*
 * T: Entity class
 * D: DTO class
 */
public abstract class AbstractCrudService<T, D> implements CrudService<T, D> {

	private static final Integer ORDER_SIZE = 2;

	protected abstract JpaSpecificationExecutor<T> getSpecificationExecutor();

	protected abstract D mapEntityToDTO(T entity);

	protected abstract Specification<T> buildSpecification(BaseDTO parameters);

	@Override
	public PaginaDTO<D> recuperarTodos(BaseDTO parameters, Integer offset, Integer limit, String ordenacao) {
		synchronized (this) {
			Pageable pageable = ordenacaoNull(ordenacao, offset, limit);
			Page<T> page = findAllComFiltro(parameters, pageable);

			PaginaDTO<D> paginaDTO = new PaginaDTO<>();
			List<D> itens = new ArrayList<>();

			paginaDTO.setTotalItens(Long.valueOf(page.getTotalElements()));
			paginaDTO.setCurrentPage(offset / limit);

			page.forEach(entity -> itens.add(mapEntityToDTO(entity)));
			paginaDTO.setItens(itens);

			return paginaDTO;
		}
	}

	@Override
	public Page<T> findAllComFiltro(BaseDTO parameters, Pageable pageable) {
		final Specification<T> specification = buildSpecification(parameters);
		return getSpecificationExecutor().findAll(specification, pageable);
	}

	protected Pageable ordenacaoNull(String ordenacao, Integer offset, Integer limit) {
		Pageable pageable;
		if (ordenacao == null || ordenacao.isEmpty()) {
			synchronized (this) {
				pageable = PageRequest.of(offset / limit, limit, Sort.by("id").ascending());
			}
		} else {
			pageable = parseOrdenacao(ordenacao, offset, limit);
		}

		return pageable;
	}

	protected Pageable parseOrdenacao(String ordenacao, Integer offset, Integer limit) {
		String[] ordens = ordenacao.split(";");
		List<Sort.Order> orders = new ArrayList<>();

		for (String ordem : ordens) {
			String[] parts = ordem.split(",");
			if (parts.length == ORDER_SIZE) {
				Sort.Order order = new Sort.Order(
						parts[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, parts[0]);
				orders.add(order);
			}
		}

		if (orders.isEmpty()) {
			return PageRequest.of(offset / limit, limit, Sort.by("id").ascending());
		}

		return PageRequest.of(offset / limit, limit, Sort.by(orders));
	}
}