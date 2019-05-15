package fr.epsi.backend.daI;

import fr.epsi.backend.domain.DrugstoreProduct;
import org.springframework.data.repository.CrudRepository;

public interface IDrugstoreProduct extends CrudRepository<DrugstoreProduct, Long> {
}
