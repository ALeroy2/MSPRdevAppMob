package fr.epsi.backend.daI;

import fr.epsi.backend.domain.Drugstore;
import org.springframework.data.repository.CrudRepository;

public interface IDrugstore extends CrudRepository<Drugstore, Long> {
}
