package poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.model.Feature;

import java.util.List;


@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

    List<Feature> findAllByValueContaining(String value);
}
