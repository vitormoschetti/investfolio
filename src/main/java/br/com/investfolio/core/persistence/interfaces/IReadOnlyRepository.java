package br.com.investfolio.core.persistence.interfaces;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

@NoRepositoryBean
public interface IReadOnlyRepository<T, IDType> extends Repository<T, IDType>, JpaSpecificationExecutor<T> {

    Optional<T> findById(IDType id);

    Collection<T> findAll();

}
