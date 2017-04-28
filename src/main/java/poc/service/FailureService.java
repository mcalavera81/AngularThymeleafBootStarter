package poc.service;

/**
 * Created on 28/04/2017.
 */
public interface FailureService {

    String failureMethodWithRecovery() throws Throwable;

    String failureMethodNotRecoverable() throws Exception;


}
