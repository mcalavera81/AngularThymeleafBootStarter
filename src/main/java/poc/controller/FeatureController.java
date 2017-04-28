package poc.controller;

import javaslang.collection.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import poc.dto.FeatureForm;
import poc.model.Container;
import poc.model.Feature;
import poc.service.ContainerService;
import poc.service.FeatureService;
import poc.validation.FeatureFormValidator;

import javax.validation.Valid;

/**
 * Created on 26/04/2017.
 */
@Controller
@RequestMapping("feature")
public class FeatureController {


    private FeatureService featureService;

    private ContainerService containerService;

    private FeatureFormValidator featureFormValidator;

    private static final String FEATURE_FORM = "/feature/create_feature";
    private static final String FEATURE_LIST = "/feature/feature_list";

    @Autowired
    public FeatureController(FeatureService featureService,
                             ContainerService containerService,
                             FeatureFormValidator featureFormValidator) {
        this.featureService = featureService;
        this.containerService = containerService;
        this.featureFormValidator = featureFormValidator;

    }


    @ModelAttribute("containers")
    public List<Container> countries() {
        return containerService.findAll();
    }

    @ModelAttribute("form_title")
    public String formTitle() {
        return "Feature Form";
    }

    @RequestMapping("create_feature")
    public String create_feature(Model model) {
        model.addAttribute(new FeatureForm());
        return FEATURE_FORM;

    }

    @RequestMapping("feature_list")
    public String feature_list(Model model) {
        return FEATURE_LIST;
    }

    @InitBinder("featureForm")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(featureFormValidator);
    }

    @RequestMapping(method = RequestMethod.POST,
            value = "/create")
    public String createForm(@ModelAttribute @Valid FeatureForm featureForm,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            return FEATURE_FORM;
        }


        Feature feature = new Feature(featureForm.getName(), featureForm.getValue(), new Container(featureForm.getContainerId()));
        featureService.addFeature(feature);
        return String.format("redirect:%s", FEATURE_LIST);
    }
}
