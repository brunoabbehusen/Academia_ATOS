package crud.projeto1.crud.Repositories;

import crud.projeto1.crud.Entities.Item;
import crud.projeto1.crud.Entities.ItensConsumidos;
import crud.projeto1.crud.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioItensConsumidos extends JpaRepository<ItensConsumidos,Integer> {

    @Query(value = "SELECT i FROM ItensConsumidos i WHERE i.reserva = ?1 AND i.item = ?2")
    List<ItensConsumidos> find_consumed_items_by_reservation(Reserva reserva, Item item);
}
