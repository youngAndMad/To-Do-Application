package daneker.code.todo_web_application.utils;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Login {

    @Email
    private String email;
    @Pattern(regexp = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=\\S+$).{8,20}$", message = "property password  contains at least 8 characters and at most 20 characters." +
            "contains at least one digit." +
            "contains at least one upper case alphabet." +
            "contains at least one lower case alphabet." +
            "does not contain any white space.")
    private String password;
}
