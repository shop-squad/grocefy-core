package pl.sda.grocefy.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.service.UserService;
import pl.sda.grocefy.product.validator.RegisterValidator;

import javax.validation.Valid;


@Controller
public class RegisterController {

    private final UserService userService;
    private final RegisterValidator registerValidator;

    @Autowired
    public RegisterController(UserService userService, RegisterValidator registerValidator) {
        this.userService = userService;
        this.registerValidator = registerValidator;
    }


    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public ModelAndView getRegisterPage() {
        ModelAndView mnv = new ModelAndView("register");
        mnv.addObject("registerInfo", new UserDTO());
        return mnv;
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    ModelAndView registerUser(Model model, @Valid @ModelAttribute("registerInfo") UserDTO registerInfo, BindingResult bindingResult) throws Exception {
        registerValidator.validate(registerInfo, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/register");
        } else {
            userService.addUser(registerInfo);
      //      return new ModelAndView("/login");
            return  new ModelAndView("index");
        }

    }
}

