package br.com.feitoamaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.feitoamaoapi.entity.ImagemProduto;

public interface ImagemProdutoRepository
		extends JpaRepository<ImagemProduto, Long>, JpaSpecificationExecutor<ImagemProduto> {

}
