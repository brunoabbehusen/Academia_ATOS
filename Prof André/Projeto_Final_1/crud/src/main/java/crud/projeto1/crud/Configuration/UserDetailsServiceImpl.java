package crud.projeto1.crud.Configuration;

import crud.projeto1.crud.Entities.UserModel;
import crud.projeto1.crud.Repositories.RepositorioUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    final RepositorioUser userRepository;

    public UserDetailsServiceImpl(RepositorioUser userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel= userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(userModel.getUsername(), userModel.getPassword(),true,true,true,true,userModel.getAuthorities());
    }
}
