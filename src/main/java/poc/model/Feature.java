package poc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by mcalavera81 on 21/04/2017.
 */
@Entity
@Table(name = "feature")
@Data
@NoArgsConstructor
public class Feature {

    public Feature(String name, String value, Container container) {
        this.name = name;
        this.value = value;
        this.container = container;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;

    @ManyToOne(optional = false)
    @JoinColumn(name = "container_id")
    private Container container;
}
