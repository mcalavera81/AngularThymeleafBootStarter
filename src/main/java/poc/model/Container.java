package poc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by mcalavera81 on 21/04/2017.
 */
@Entity
@Table(name = "container")
@Data
@NoArgsConstructor
public class Container {

    public Container(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


}
