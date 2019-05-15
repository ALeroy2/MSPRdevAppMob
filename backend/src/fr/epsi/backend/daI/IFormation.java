package fr.epsi.backend.daI;

import fr.epsi.backend.domain.Formation;
import org.springframework.data.repository.CrudRepository;

public interface IFormation extends CrudRepository<Formation, Long> {
}
