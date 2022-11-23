package crud.projeto1.crud.Repositories;

import crud.projeto1.crud.Entities.Cama;
import crud.projeto1.crud.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RepositorioCama extends JpaRepository<Cama,Integer> {

    @Query(value="SELECT c FROM Cama c WHERE c.reserva = null AND c.tipo = ?1")
    List<Cama> find_free_beds_by_type(String type);

    @Query(value="SELECT c FROM Cama c WHERE c.reserva = ?1")
    List<Cama> find_beds_with_reservation(Reserva reserva);

    //Atualizar a cama com a nova reserva
    @Modifying
    @Transactional
    @Query("UPDATE Cama c SET c.reserva = ?1 WHERE c.id = ?2")
    void update_bed_reservation(Reserva reservation, Integer id_bed);
}
