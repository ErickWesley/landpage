package tumnus.landpage.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tumnus.landpage.domain.integration.request.UserRequest;
import tumnus.landpage.domain.integration.response.UserResponse;
import tumnus.landpage.domain.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UserController {

    private final UserService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> salvarUsuario (@RequestBody @Valid UserRequest userRequest) {
        return service.salvar(userRequest);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponse>> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }




    /*@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> listarTodos() {
        List<User> usuarios = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }



    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id) {
        Optional<User> optionalUser = service.buscarPorId(id);

        if(optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalUser.get());
    }

    *//*@PutMapping
    public ResponseEntity<User> alterar (@RequestBody User user) {
        User userSalvo = service.salvar(user);
        return ResponseEntity.status(HttpStatus.OK).body(userSalvo);
    }*//*

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/



    //Pesquisar método builder

    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    // Criar a DTO para trafegar e será feita na service. Usar o get e set para fazer o mapeamento.
    public ResponseEntity<User> salvarUsuario(@RequestBody User user) {
        User usuarioSalvo = service.salvar(user);

        //Colocar o response entity do return para a classe UserService
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }*/



}
