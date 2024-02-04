package br.com.feitoamaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.feitoamaoapi.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>, JpaSpecificationExecutor<Vendedor> {

}
