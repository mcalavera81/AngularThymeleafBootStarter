package poc.service;

import javaslang.collection.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import poc.model.Feature;
import poc.repository.FeatureRepository;


@Service("featureService")
public class FeatureServiceImpl implements FeatureService {

    private final static Logger log = Logger.getLogger(FeatureServiceImpl.class);


    private FeatureRepository featureRepo;

    @Autowired
    public FeatureServiceImpl(FeatureRepository featureRepo) {
        this.featureRepo = featureRepo;
    }

    @Override
    public List<Feature> findAll() {
        return List.ofAll(featureRepo.findAll());
    }

    @Override
    public List<Feature> findFeaturesContaining(String value) {
        if (StringUtils.isNoneEmpty(value)) {
            return List.ofAll(featureRepo.findAllByValueContaining(value));
        } else {
            return List.empty();
        }

    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteFeature(Long id) {
        featureRepo.delete(id);
    }

    @Override
    public Feature addFeature(Feature feature) {
        return featureRepo.save(feature);
    }
}
