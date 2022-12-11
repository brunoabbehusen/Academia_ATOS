package crud.projeto1.crud.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud.projeto1.crud.Entities.Veiculo;
import crud.projeto1.crud.Repositories.RepositorioVeiculo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/veiculo")
public class VeiculoREST {

    @Autowired
    private RepositorioVeiculo repositorio;

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    public List<Veiculo> listar() throws JsonProcessingException {

        return repositorio.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody Veiculo veiculoFromRequest){

        Veiculo veiculo = new Veiculo(veiculoFromRequest.getId(), veiculoFromRequest.getPlaca());

        repositorio.save(veiculo);

        log.info("Veiculo salvo com sucesso");
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable int id){

        repositorio.deleteById(id);
        log.info("Veiculo deletado com sucesso!!");

    }

}
