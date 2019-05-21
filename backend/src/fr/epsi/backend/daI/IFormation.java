package fr.epsi.backend.daI;

import fr.epsi.backend.domain.Formation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IFormation extends CrudRepository<Formation, Long> {
}
