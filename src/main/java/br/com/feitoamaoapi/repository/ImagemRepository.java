package br.com.feitoamaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.feitoamaoapi.entity.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long>, JpaSpecificationExecutor<Imagem> {

}
