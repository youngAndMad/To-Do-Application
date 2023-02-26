package daneker.code.todo_web_application.repositories;

import daneker.code.todo_web_application.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> getClientByEmail(String email);
    Optional<Client> getClientByEmailAndPassword(String email , String password);
}
