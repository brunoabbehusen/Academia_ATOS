package crud.projeto1.crud.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.projeto1.crud.Entities.Cama;
import crud.projeto1.crud.Entities.Hospede;
import crud.projeto1.crud.Repositories.RepositorioCama;
import crud.projeto1.crud.Repositories.RepositorioHospede;
import crud.projeto1.crud.Repositories.RepositorioReserva;
import crud.projeto1.crud.Entities.Reserva;
import crud.projeto1.crud.ViewModels.ReservaCamaId;
import crud.projeto1.crud.ViewModels.ReservaFromRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", maxAge = 3600)
@RequestMapping("/reservas")
public class ReservaREST {

    @Autowired
    private RepositorioReserva repositorio_reserva;

    @Autowired
    private RepositorioCama repositorio_cama;

    @Autowired
    private RepositorioHospede repositorio_hospede;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public List<ReservaCamaId> listar() throws JsonProcessingException {

        List<Reserva> result_reservas = repositorio_reserva.findAll();

        List<ReservaCamaId> reservas_com_cama = new ArrayList<>();

        //Para cada "reserva" existente na "result_reservas" ele executa uma vez
        for(Reserva reserva : result_reservas){

            List<Cama> camas = repositorio_cama.find_beds_with_reservation(reserva);

            ReservaCamaId reserva_com_cama = new ReservaCamaId(reserva ,null);

            if(!camas.isEmpty()){
                reserva_com_cama.setCama_id(camas.get(0).getId());
            }

            reservas_com_cama.add(reserva_com_cama);
        }

        log.info("Listando as reservas com camas");

        return reservas_com_cama;
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody ReservaFromRequest reserva_from_request){

        Optional<Hospede> hospede_optional = repositorio_hospede.findById(reserva_from_request.getId_hospede());

        if(hospede_optional.isEmpty()) return;

        Hospede hospede = hospede_optional.get();

        List<Cama> cama_list = repositorio_cama.find_free_beds_by_type(reserva_from_request.getTipo_cama());

        if(cama_list.isEmpty()) return;

        Cama cama = cama_list.get(0);

        Reserva reserva = new Reserva(hospede, cama.getValor(), reserva_from_request.getQnt_diarias());

        Reserva reserva_salva = repositorio_reserva.save(reserva);

        repositorio_cama.update_bed_reservation(reserva_salva, cama.getId());

        hospede.setReserva(reserva);

        repositorio_hospede.save(hospede);

        log.info("Salvando reserva e atualizando a cama!!");
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PatchMapping("/checkout/{id}")
    public void checkout(@PathVariable int id){

        Optional<Reserva> reserva_optional = repositorio_reserva.findById(id);

        if(reserva_optional.isEmpty()) return;

        List<Cama> camas = repositorio_cama.find_beds_with_reservation(reserva_optional.get());

        if(camas.isEmpty()) return;

        Cama cama = camas.get(0);

        cama.setReserva(null);

        repositorio_cama.save(cama);

        log.info("Atualizando a cama!!");
    }
}
