package crud.projeto1.crud.Repositories;

import crud.projeto1.crud.Entities.Cama;
import crud.projeto1.crud.Entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface RepositorioQuarto extends JpaRepository <Quarto,Integer> {

    List<Cama> findAllByIdIn(ArrayList<Integer> camas);

}
