package poc.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created on 28/04/2017.
 */
@Service
public class FailureServiceImpl implements FailureService {

    @Override
    @Retryable(
            value = {RuntimeException.class},
            maxAttempts = 2,
            backoff = @Backoff(delay = 2000, multiplier = 2))
    public String failureMethodWithRecovery() throws Throwable {
        System.out.println("Failure method failureMethodWithRecovery called." + new Date());
        throw new RuntimeException("ooops!");
    }

    @Override
    @Retryable(
            value = {Exception.class},
            maxAttempts = 2,
            backoff = @Backoff(delay = 2000, multiplier = 2))
    public String failureMethodNotRecoverable() throws Exception {
        System.out.println("Failure method failureMethodNotRecoverable called." + new Date());
        throw new Exception("ooops!");
    }

    @Recover
    public String recover(RuntimeException exception) {
        System.out.println("Recovering from " + exception);
        return "recovered";
    }
}
