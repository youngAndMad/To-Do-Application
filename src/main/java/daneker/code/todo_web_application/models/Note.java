package daneker.code.todo_web_application.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "note")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id",
            referencedColumnName = "id")
    private Client owner;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Column(name = "note_type")
    private String noteType;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "state")
    private String state;

}
