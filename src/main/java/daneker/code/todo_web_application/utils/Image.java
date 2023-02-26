package daneker.code.todo_web_application.utils;

import daneker.code.todo_web_application.models.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.math.BigInteger;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name ="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "size")
    private Long size;

    @Column(name = "content_type")
    private String contentType;

    @Lob
    @Column(name = "bytes")
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Client client;

}
