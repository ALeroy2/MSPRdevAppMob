package fr.epsi.backend.daI;

import fr.epsi.backend.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProduct extends CrudRepository<Product, Long> {
}
