package poc;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

/**
 * Created on 21/04/2017.
 */
@ActiveProfiles("test")
@Sql("/seed.sql")
public class BaseTest {
}
