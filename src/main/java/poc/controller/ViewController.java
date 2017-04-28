package poc.controller;

import org.springframework.stereotype.Controller;
import poc.service.ContainerService;

/**
 * Created on 25/04/2017.
 */
@Controller
public class ViewController {

    private ContainerService containerService;

    public ViewController(ContainerService containerService) {
        this.containerService = containerService;

    }


    /*@RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Farid");
        //model.addAttribute("mode", "development");
        model.addAttribute("mode", "production");


        return "index";
    }*/

}
