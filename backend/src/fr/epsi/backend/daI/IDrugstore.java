package fr.epsi.backend.daI;

import fr.epsi.backend.domain.Drugstore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IDrugstore extends CrudRepository<Drugstore, Long> {
}
