package crud.projeto1.crud.Controllers;

import crud.projeto1.crud.Entities.Cama;
import crud.projeto1.crud.Entities.Quarto;
import crud.projeto1.crud.Repositories.RepositorioCama;
import crud.projeto1.crud.Repositories.RepositorioQuarto;
import crud.projeto1.crud.ViewModels.CamaFromRequest;
import crud.projeto1.crud.ViewModels.CamaToResponse;
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
@RequestMapping("/camas")
public class CamaREST {


    @Autowired
    private RepositorioCama repositorio;

    @Autowired
    private RepositorioQuarto repositorio_quarto;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public List<CamaToResponse> listar(){

        log.info("Listando todas as camas");

        List<Cama> camas = repositorio.findAll();

        List<CamaToResponse> cama_list = new ArrayList<>();

        for(Cama cama : camas){
            cama_list.add(CamaToResponse.mapCamaToCamaList(cama));
        }

        return cama_list;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody CamaFromRequest cama_from_request){

        Optional<Quarto> quartoOptional = repositorio_quarto.findById(cama_from_request.getQuarto_id());

        if(quartoOptional.isEmpty()) return;

        Quarto quarto = quartoOptional.get();

        Cama cama = new Cama(cama_from_request.getId(),cama_from_request.getValor(), cama_from_request.getTipo(), quarto);
        repositorio.save(cama);

        log.info("Cama cadastrada com sucesso");
    }

}
