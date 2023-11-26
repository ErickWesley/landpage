package tumnus.landpage.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import tumnus.landpage.domain.entity.User;
import tumnus.landpage.domain.integration.request.UserRequest;
import tumnus.landpage.domain.integration.response.UserResponse;
import tumnus.landpage.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    public ResponseEntity<UserResponse> salvar (UserRequest userRequest) {
        log.info("Persistindo um novo usuário");


        User usuarioPadrao = User.builder()
                .cpf(userRequest.getCpf())
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .build();

        User usuarioSalvo = userRepository.save(usuarioPadrao);
        log.info("Usuário salvo");

        UserResponse userResponse = UserResponse.builder()
                .id(usuarioSalvo.getId())
                .cpf(usuarioSalvo.getCpf())
                .email(usuarioSalvo.getEmail())
                .name(usuarioSalvo.getName())
                .build();


        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);

    }

    public ResponseEntity<List<UserResponse>> listarTodos() {
        List<User> usuarios = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        usuarios.forEach(user -> {
            UserResponse userResponse = UserResponse.builder()
                    .id(user.getId())
                    .cpf(user.getCpf())
                    .email(user.getEmail())
                    .name(user.getName())
                    .build();
            userResponses.add(userResponse);
        });
        return ResponseEntity.status(HttpStatus.OK).body(userResponses);

    }

    public ResponseEntity<UserResponse> buscarPorId(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UserResponse userResponse = UserResponse.builder()
                .id(optionalUser.get().getId())
                .cpf(optionalUser.get().getCpf())
                .email(optionalUser.get().getEmail())
                .name(optionalUser.get().getName())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }


    /*public User salvar (User user) {
        return repository.save(user);
    }*/

    /*public List<User> listarTodos () {
        return repository.findAll();
    }

    public Optional<User> buscarPorId (Long id) {
        return repository.findById(id);
    }

    public void deletar (Long id) {
        repository.deleteById(id);
    }*/

}
