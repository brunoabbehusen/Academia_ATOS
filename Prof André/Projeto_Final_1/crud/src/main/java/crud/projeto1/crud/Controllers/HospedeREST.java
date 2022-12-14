package crud.projeto1.crud.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import crud.projeto1.crud.Entities.Veiculo;
import crud.projeto1.crud.Repositories.RepositorioHospede;
import crud.projeto1.crud.Entities.Hospede;
import crud.projeto1.crud.Repositories.RepositorioVeiculo;
import crud.projeto1.crud.ViewModels.HospedeFromRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true", maxAge = 3600)
@RequestMapping("/hospedes")
public class HospedeREST {

    @Autowired
    private RepositorioHospede repositorio;

    @Autowired
    private RepositorioVeiculo repositorio_veiculo;

    @GetMapping
    public List<Hospede> listar() throws JsonProcessingException {

        return repositorio.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody HospedeFromRequest hospedeFromRequest){

        Hospede hospede = new Hospede(hospedeFromRequest.getNomeCompleto());
        repositorio.save(hospede);

        Veiculo veiculo = new Veiculo(hospedeFromRequest.getPlaca(), hospede);
        repositorio_veiculo.save(veiculo);

        log.info("Hospede cadastrado com sucesso");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<String> alterar(@RequestBody HospedeFromRequest hospedeFromRequest, @PathVariable int id){

        Optional<Hospede> result = repositorio.findById(id);

        if(result.isEmpty()){
            return new ResponseEntity<>("Hóspede não encontrado", HttpStatus.NOT_FOUND);
        }
        
        Hospede hospede = result.get();

        hospede.setNome_Completo(hospedeFromRequest.getNomeCompleto());

        String novaPlaca = hospedeFromRequest.getPlaca();

        if ( novaPlaca != null ) {
            Veiculo veiculo = hospede.getVeiculo();

            if( veiculo != null ) {
                veiculo.setPlaca(novaPlaca);
            } else {
                Veiculo novoVeiculo = new Veiculo(novaPlaca, hospede);

                hospede.setVeiculo(novoVeiculo);
            }
        }

        repositorio.save(hospede);

        log.info("Hóspede alterado com sucesso!!");

        return new ResponseEntity<>("Hóspede alterado com sucesso!!", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> excluir(@PathVariable int id){

        Optional<Hospede> hospede_optional = repositorio.findById(id);

        if(hospede_optional.isEmpty()) return new ResponseEntity<>("Hóspede não encontrado", HttpStatus.NOT_FOUND);

        Hospede hospede = hospede_optional.get();

        if(hospede.getVeiculo() != null){
            repositorio_veiculo.deleteById(hospede.getVeiculo().getId());
        }

        repositorio.deleteById(id);
        log.info("Hospede deletado com sucesso!!");

        return new ResponseEntity<>("Hóspede deletado com sucesso!!", HttpStatus.OK);
    }
}
