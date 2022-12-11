package crud.projeto1.crud.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.projeto1.crud.Entities.Item;
import crud.projeto1.crud.Entities.ItensConsumidos;
import crud.projeto1.crud.Entities.Reserva;
import crud.projeto1.crud.Repositories.RepositorioItem;
import crud.projeto1.crud.Repositories.RepositorioItensConsumidos;
import crud.projeto1.crud.Repositories.RepositorioReserva;
import crud.projeto1.crud.ViewModels.ConsumacaoFromRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/reservas/{id}/consumo")
public class ReservaConsumoREST {

    @Autowired
    private RepositorioItem repositorio_item;

    @Autowired
    private RepositorioItensConsumidos repositorio_itens_consumidos;

    @Autowired
    private RepositorioReserva repositorio_reserva;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public List<ItensConsumidos> listar() throws JsonProcessingException {

        log.info("Itens listados");

        return repositorio_itens_consumidos.findAll();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody ConsumacaoFromRequest consumacao_from_request, @PathVariable int id){


        //Buscar reserva através do id passado, se não existir, abortar (return)
        Optional<Reserva> reserva_optional = repositorio_reserva.findById(id);

        if(reserva_optional.isEmpty()) return;

        Reserva reserva = reserva_optional.get();

        //Buscar item através do id passado, se não existir, abortar (return)
        Optional<Item> item_optional = repositorio_item.findById(consumacao_from_request.getId_item());

        if(item_optional.isEmpty()) return;

        Item item = item_optional.get();

        List<ItensConsumidos> consumo = repositorio_itens_consumidos.find_consumed_items_by_reservation(reserva, item);

        //Se não houver consumação com este item, criar uma consumação nova com a reserva, o item e a quantidade
        ItensConsumidos itens_consumidos;
        if(consumo.isEmpty()){

            itens_consumidos = new ItensConsumidos(reserva, item, consumacao_from_request.getQuantidade());
        }else{ //Se houver consumação com este item, incrementar quantidade

            itens_consumidos = consumo.get(0);
            itens_consumidos.setQuantidade(itens_consumidos.getQuantidade() + consumacao_from_request.getQuantidade());
        }

        repositorio_itens_consumidos.save(itens_consumidos);

        reserva.calc_valor_total();

        repositorio_reserva.save(reserva);

        log.info("Item vinculado com sucesso");
    }
}
