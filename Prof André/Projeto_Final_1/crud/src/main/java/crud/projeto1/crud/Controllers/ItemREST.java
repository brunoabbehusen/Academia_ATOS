package crud.projeto1.crud.Controllers;

import crud.projeto1.crud.Entities.Item;
import crud.projeto1.crud.Repositories.RepositorioItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/item")
public class ItemREST {


    @Autowired
    private RepositorioItem repositorio;

    @GetMapping
    public List<Item> listar(){

        log.info("Listagem de itens cadastrados");

        return repositorio.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody Item itemFromRequest){

        Item item = new Item(itemFromRequest.getNome(), itemFromRequest.getValor());
        repositorio.save(item);
        log.info("Item cadastrado com sucesso");
    }

}
