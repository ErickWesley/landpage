package tumnus.landpage.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tumnus.landpage.domain.entity.User;
import tumnus.landpage.domain.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;

    @Test
    @DisplayName("deve salvar um novo usuário com sucesso!")
    void salvarComSucesso() {

        User user = new User();
        user.setId(1L);
        user.setName("Iori");
        user.setEmail("iori@gmail.com");
        user.setCpf("94588643389");

        Mockito.when(repository.save(user)).thenReturn(user);

        /*service.salvar(user);*/

        Mockito.verify(repository, Mockito.times(1)).save(user);


    }
}