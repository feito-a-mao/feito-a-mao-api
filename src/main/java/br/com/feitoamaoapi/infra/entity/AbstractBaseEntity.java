package br.com.feitoamaoapi.infra.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractBaseEntity<T> {
	public abstract T getId();
}
