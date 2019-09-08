package pl.sda.grocefy.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView getHomePage(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("hash", generateHash());
        return mav;
    }

    private String generateHash(){
        return  LocalDateTime.now().toString();
    }
}
