package daneker.code.todo_web_application.repositories;

import daneker.code.todo_web_application.utils.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends JpaRepository <Image , Integer>{

}
