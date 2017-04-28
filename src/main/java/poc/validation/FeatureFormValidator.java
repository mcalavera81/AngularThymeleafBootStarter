package poc.validation;

import javaslang.collection.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import poc.dto.FeatureForm;
import poc.model.Feature;
import poc.service.FeatureService;

@Component
public class FeatureFormValidator implements Validator {

    @Autowired
    private FeatureService featureService;

    @Override
    public boolean supports(Class<?> clazz) {
        return FeatureForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FeatureForm form = (FeatureForm) target;


        List<Feature> featuresContaining = featureService.findFeaturesContaining(form.getValue());
        if (featuresContaining.size() > 0) {
            errors.reject("repeated", "default message");
        }

    }
}