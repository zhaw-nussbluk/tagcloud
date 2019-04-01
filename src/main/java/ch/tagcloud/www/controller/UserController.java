package ch.tagcloud.www.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.tagcloud.www.model.User;
import ch.tagcloud.www.service.SecurityService;
import ch.tagcloud.www.service.UserService;
import ch.tagcloud.www.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private SecurityService securityService;
	
	@Autowired
    private UserValidator userValidator;
	
	@GetMapping(value = "/login")
    public String loginPage(Model model) {
 
        return "login";
    }
    
	@GetMapping(value = "/register")
    public String registerPage(Model model) {
    	
    	model.addAttribute("userForm", new User());
 
        return "register";
    }
    
    @PostMapping(value = "/register")
    public String registerAddPage(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
    	
    	userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }
    	
    	userService.save(userForm);
    	
    	securityService.autoLogin(userForm.getMail(), userForm.getPasswordConfirm());
 
    	return "redirect:/index?register=true";
    }

}