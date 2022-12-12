package crud.projeto1.crud.Controllers;

import crud.projeto1.crud.Entities.UserModel;
import crud.projeto1.crud.Repositories.RepositorioUser;
import crud.projeto1.crud.ViewModels.UsuarioFromRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@PreAuthorize("permitAll()")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginREST {

    @Autowired
    final RepositorioUser userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public LoginREST(RepositorioUser userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<String> authenticateUser(@RequestBody UsuarioFromRequest usuariofromrequest) throws Exception{

        Optional<UserModel> user = userRepository.findByUsername(usuariofromrequest.getUsername());


        if(user.isEmpty()){
            return new ResponseEntity<>("Usuario nao encontrado",HttpStatus.NOT_FOUND);
        } else{
            String senhadobanco = user.get().getPassword();
            //String senhahash = passwordEncoder.matches(usuariofromrequest.getPassword());
            if(passwordEncoder.matches(usuariofromrequest.getPassword(),senhadobanco)){
                return new ResponseEntity<>("Login realizado com sucesso",HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Senha inválida",HttpStatus.FORBIDDEN);
            }
        }
    }
}
