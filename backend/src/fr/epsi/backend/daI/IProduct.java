package fr.epsi.backend.daI;

import fr.epsi.backend.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IProduct extends CrudRepository<Product, Long> {
}
