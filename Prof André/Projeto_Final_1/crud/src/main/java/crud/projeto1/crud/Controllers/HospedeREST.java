package crud.projeto1.crud.Controllers;

import crud.projeto1.crud.Entities.Veiculo;
import crud.projeto1.crud.Repositories.RepositorioHospede;
import crud.projeto1.crud.Entities.Hospede;
import crud.projeto1.crud.Repositories.RepositorioVeiculo;
import crud.projeto1.crud.ViewModels.HospedeFromRequest;
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

    @Autowired
    private RepositorioVeiculo repositorio_veiculo;

    @GetMapping
    public List<Hospede> listar(){

        return repositorio.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody HospedeFromRequest hospedeFromRequest){

        Hospede hospede = new Hospede(hospedeFromRequest.getNome_Completo());
        repositorio.save(hospede);

        Veiculo veiculo = new Veiculo(hospedeFromRequest.getPlaca(), hospede);
        repositorio_veiculo.save(veiculo);

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

        Optional<Hospede> hospede_optional = repositorio.findById(id);
        if(hospede_optional.isEmpty()) return;

        Hospede hospede = hospede_optional.get();

        if(hospede.getVeiculo() != null){

            repositorio_veiculo.deleteById(hospede.getVeiculo().getId());
        }

        repositorio.deleteById(id);
        log.info("Hospede deletado com sucesso!!");
    }
}
