package ch.tagcloud.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.tagcloud.www.model.User;
import ch.tagcloud.www.service.SecurityService;
import ch.tagcloud.www.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private SecurityService securityService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "login";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
    	
    	model.addAttribute("userForm", new User());
 
        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerAddPage(Model model, User userForm) {
    	
    	userService.save(userForm);
    	
    	securityService.autoLogin(userForm.getMail(), userForm.getPasswordConfirm());
 
    	return "redirect:/index";
    }

}