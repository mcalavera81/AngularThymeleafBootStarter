package poc.controller.rest;

import javaslang.collection.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import poc.model.Feature;
import poc.service.FeatureService;


@RestController
@RequestMapping("/rest/feature")
public class FeatureRestController {


    private FeatureService featureService;

    @Autowired
    public FeatureRestController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public List<Feature> getFeatures(@RequestParam(value = "filter", required = false) String filter) {
        if (filter != null) {
            return featureService.findFeaturesContaining(filter);
        } else {
            return featureService.findAll();
        }

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public void deleteFeature(@PathVariable(value = "id") Long id) {
        featureService.deleteFeature(id);
    }

}


