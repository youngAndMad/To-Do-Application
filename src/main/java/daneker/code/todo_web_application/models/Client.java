package daneker.code.todo_web_application.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    @Size(min = 2, max = 30, message = "property first name should be between 2 and 30 characters")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 30, message = "property last name should be between 2 and 30 characters")
    private String lastname;

    @Min(value = 0, message = "property age should be greater than 0")
    private int age;

    @Email(message = "property email should be valid")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=\\S+$).{8,20}$", message = "property password  contains at least 8 characters and at most 20 characters." +
            "contains at least one digit." +
            "contains at least one upper case alphabet." +
            "contains at least one lower case alphabet." +
            "does not contain any white space.")
    private String password;

    @OneToMany
    @JoinColumn(name = "client_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Note> notes;

    @Column(name = "gender")
    private String gender;


}
