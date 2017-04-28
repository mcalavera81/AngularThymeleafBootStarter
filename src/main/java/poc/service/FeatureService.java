package poc.service;


import javaslang.collection.List;
import poc.model.Feature;


public interface FeatureService {

    List<Feature> findAll();

    List<Feature> findFeaturesContaining(String value);

    void deleteFeature(Long id);

    Feature addFeature(Feature feature);

}
