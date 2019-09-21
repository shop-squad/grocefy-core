package pl.sda.grocefy.product.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.exception.ListNotFoundException;
import pl.sda.grocefy.product.exception.WebApplicationException;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ListNotFoundException.class)
    public ModelAndView productNotFoundException(Exception exception){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
