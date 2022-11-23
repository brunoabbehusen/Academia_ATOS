package crud.projeto1.crud.Controllers;

import crud.projeto1.crud.Entities.Cama;
import crud.projeto1.crud.Entities.Hospede;
import crud.projeto1.crud.Repositories.RepositorioCama;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/camas")
public class CamaREST {


    @Autowired
    private RepositorioCama repositorio;

    @GetMapping
    public List<Cama> listar(){

        log.info("Listando todas as camas");

        return repositorio.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody Cama cama_from_request){

        Cama cama = new Cama(cama_from_request.getId(),cama_from_request.getValor(), cama_from_request.getTipo());
        repositorio.save(cama);

        log.info("Cama cadastrada com sucesso");
    }

}
