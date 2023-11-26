package tumnus.landpage.domain.integration.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

    /*@NotEmpty(message = "Campo nome é obrigatório.")*/
    private String name;
    private String email;
    private String cpf;



}
