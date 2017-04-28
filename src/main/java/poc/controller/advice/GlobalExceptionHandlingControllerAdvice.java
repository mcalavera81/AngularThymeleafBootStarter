package poc.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created on 27/04/2017.
 */
//@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlingControllerAdvice {


    @ExceptionHandler(Throwable.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception)
            throws Exception {

        log.error("Request: " + req.getRequestURI() + " raised " + exception);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("timestamp", new Date().toString());
        mav.addObject("status", 500);

        mav.setViewName("/error");
        return mav;
    }
}
