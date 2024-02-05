package br.com.feitoamaoapi.mapper;

import br.com.feitoamaoapi.dto.ProdutoDTO;
import br.com.feitoamaoapi.entity.Produto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProdutoMapper {

	public static ProdutoDTO fromEntityToDTO(Produto produto) {
		if (produto == null) {
			return null;
		}

		return ProdutoDTO.builder()//
				.id(produto.getId())//
				.nome(produto.getNome())//
				.descricao(produto.getDescricao())//
				.preco(produto.getPreco())//
				.estoqueDisponivel(produto.getEstoqueDisponivel())//
				.dataCriacao(produto.getDataCriacao())//
				.vendedor(VendedorMapper.fromEntityToDTO(produto.getVendedor()))//
				.build();
	}

	public static Produto fromDTOtoEntity(ProdutoDTO dto) {
		if (dto == null) {
			return null;
		}

		return Produto.builder().id(dto.getId()) //
				.nome(dto.getNome()) //
				.descricao(dto.getDescricao()) //
				.preco(dto.getPreco()) //
				.estoqueDisponivel(dto.getEstoqueDisponivel()) //
				.dataCriacao(dto.getDataCriacao()) //
				.vendedor(VendedorMapper.fromDTOtoEntity(dto.getVendedor())) //
				.build();
	}
}
