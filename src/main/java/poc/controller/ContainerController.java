package poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poc.service.ContainerService;

/**
 * Created on 26/04/2017.
 */
@Controller
@RequestMapping("container")
public class ContainerController {

    private static final String CONTAINER_LIST = "container/container_list";


    private ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }


    @RequestMapping("container_list")
    public String containersList(Model model) {
        model.addAttribute("containers", containerService.findAll());
        return CONTAINER_LIST;

    }
}
