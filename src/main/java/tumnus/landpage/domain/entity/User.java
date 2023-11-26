package tumnus.landpage.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@ToString
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    /*@NotEmpty(message = "Campo nome é obrigatório.")*/
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "cpf", unique = true)
    private String cpf;


}
