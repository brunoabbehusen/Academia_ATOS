package crud.projeto1.crud.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.projeto1.crud.Entities.Quarto;
import crud.projeto1.crud.Repositories.RepositorioCama;
import crud.projeto1.crud.Repositories.RepositorioQuarto;
import crud.projeto1.crud.ViewModels.QuartoFromRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/quarto")
public class QuartoREST {

    @Autowired
    private RepositorioQuarto repositorio;

    @Autowired
    private RepositorioCama repositorio_cama;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public List<Quarto> listar() throws JsonProcessingException {



        log.info("Listagem de quartos cadastrados");

        return repositorio.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody QuartoFromRequest quartoFromRequest){

        Quarto quarto = new Quarto(quartoFromRequest.getId(), quartoFromRequest.getNome_quarto());

        repositorio.save(quarto);

        log.info("Quarto cadastrado com sucesso");
    }
}
