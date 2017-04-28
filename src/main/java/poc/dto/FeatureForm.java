package poc.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created on 26/04/2017.
 */

@Getter
@Setter
public class FeatureForm {


    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotEmpty
    private String value;

    @NotNull
    private Long containerId;

}
