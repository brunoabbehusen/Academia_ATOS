package crud.projeto1.crud.Repositories;

import crud.projeto1.crud.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioItem extends JpaRepository<Item,Integer> {

}
