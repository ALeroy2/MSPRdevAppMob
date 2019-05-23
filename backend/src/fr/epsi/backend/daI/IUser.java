package fr.epsi.backend.daI;

import fr.epsi.backend.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IUser extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
