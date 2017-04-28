package poc.service;

import javaslang.collection.List;
import javaslang.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.model.Container;
import poc.repository.ContainerRepository;

/**
 * Created on 23/04/2017.
 */
@Service
public class ContainerServiceImpl implements ContainerService {


    private ContainerRepository containerRepository;

    @Autowired
    public ContainerServiceImpl(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    @Override
    public Option<Container> findById(Long id) {
        return Option.of(containerRepository.findOne(id));
    }

    @Override
    public List<Container> findAll() {
        return List.ofAll(containerRepository.findAll());
    }
}
