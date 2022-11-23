package crud.projeto1.crud.Controllers;

import crud.projeto1.crud.Repositories.RepositorioHospede;
import crud.projeto1.crud.Entities.Hospede;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/hospedes")
public class HospedeREST {

    @Autowired
    private RepositorioHospede repositorio;

    @GetMapping
    public List<Hospede> listar(){

        return repositorio.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody Hospede hospedeFromRequest){

        Hospede hospede = new Hospede(hospedeFromRequest.getNome_Completo());
        repositorio.save(hospede);
        log.info("Hospede cadastrado com sucesso");
    }

    @PutMapping("{id}")
    public void alterar(@RequestBody Hospede hospedeFromRequest, @PathVariable int id){

        Hospede hospede = new Hospede(hospedeFromRequest.getNome_Completo(), id);

        Optional<Hospede> result = repositorio.findById(id);
        if(result.isPresent()){
            repositorio.save(hospede);
        }
        log.info("Hospede alterado com sucesso!!");
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable int id){

        repositorio.deleteById(id);
        log.info("Hospede deletado com sucesso!!");
    }
}
