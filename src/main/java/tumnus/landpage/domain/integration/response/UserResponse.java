package tumnus.landpage.domain.integration.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private Long id;
    /*@NotEmpty(message = "Campo nome é obrigatório.")*/
    private String name;
    private String email;
    private String cpf;


}
