package poc.service;

import javaslang.collection.List;
import javaslang.control.Option;
import poc.model.Container;

/**
 * Created on 23/04/2017.
 */
public interface ContainerService {

    Option<Container> findById(Long id);

    List<Container> findAll();
}
