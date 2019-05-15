package fr.epsi.backend.daI;

import fr.epsi.backend.domain.ProductPrice;
import org.springframework.data.repository.CrudRepository;

public interface IProductPrice extends CrudRepository<ProductPrice, Long> {
}
