package crud.projeto1.crud.Repositories;

import crud.projeto1.crud.Entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositorioUser extends JpaRepository<UserModel,UUID> {

    Optional<UserModel> findByUsername(String username);
}
