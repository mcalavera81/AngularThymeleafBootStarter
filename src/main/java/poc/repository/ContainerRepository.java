package poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.model.Container;

/**
 * Created on 23/04/2017.
 */
@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

}
