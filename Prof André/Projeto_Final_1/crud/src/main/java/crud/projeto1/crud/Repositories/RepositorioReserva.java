package crud.projeto1.crud.Repositories;

import crud.projeto1.crud.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioReserva extends JpaRepository<Reserva,Integer> {
}
