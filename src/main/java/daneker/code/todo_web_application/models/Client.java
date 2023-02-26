package daneker.code.todo_web_application.models;


import daneker.code.todo_web_application.utils.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
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
    private String firstName;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "client_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Note> notes;

    @Column(name = "gender")
    private String gender;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "client")
    private List<Image> avatars;

}
