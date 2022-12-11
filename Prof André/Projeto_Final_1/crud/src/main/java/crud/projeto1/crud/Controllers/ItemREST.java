package crud.projeto1.crud.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.projeto1.crud.Entities.Item;
import crud.projeto1.crud.Repositories.RepositorioItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/item")
public class ItemREST {


    @Autowired
    private RepositorioItem repositorio;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public List<Item> listar() throws JsonProcessingException {



        log.info("Listagem de itens cadastrados");

        return repositorio.findAll();
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody Item itemFromRequest){

        Item item = new Item(itemFromRequest.getNome(), itemFromRequest.getValor());
        repositorio.save(item);
        log.info("Item cadastrado com sucesso");
    }

}
