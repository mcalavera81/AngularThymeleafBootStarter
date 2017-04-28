package poc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import poc.service.FailureService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created on 28/04/2017.
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class RetryTest {

    @Autowired
    private FailureService failureService;

    @Autowired
    private RetryTemplate retryTemplate;

    @Test
    public void testRetryWithRecovery() throws Throwable {
        assertThat(failureService.failureMethodWithRecovery(), is("recovered"));
    }

    @Test(expected = Exception.class)
    public void testRetryNotRecoverable() throws Exception {
        failureService.failureMethodNotRecoverable();
    }

    @Test
    public void withTemplateWithRecovery() throws Exception {

        String recoveryStr = "recovered_template";

        assertThat(retryTemplate.<String, Exception>execute(
                (RetryContext context) -> failureService.failureMethodNotRecoverable(),
                retryContext -> recoveryStr), is(recoveryStr));

    }
}
