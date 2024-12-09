package group.isi.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="products")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    @Column(nullable = false, unique = true)
    private String ref;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double stock;

    @Column(nullable = false)
    private long idUser;
}
