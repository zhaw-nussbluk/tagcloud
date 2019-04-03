package ch.tagcloud.www.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.tagcloud.www.model.User;
import ch.tagcloud.www.repository.RoleRepository;
import ch.tagcloud.www.service.SecurityService;
import ch.tagcloud.www.service.UserService;
import ch.tagcloud.www.validator.ProfileValidator;
import ch.tagcloud.www.validator.UserValidator;

@Controller
public class ProfilexController {
	
	@Autowired
    private UserService userService;
	
    @Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private ProfileValidator profileValidator;

	@GetMapping(value = "/profile")
    public String profilePage(Model model, Principal principal) {	
		
		String username = principal.getName();
    	
    	model.addAttribute("userForm", userService.findByMail(username));
    	
 
        return "profile";
    }
	
	@PostMapping(value = "/profile")
    public String profileUpdate(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
    	
    	profileValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "profile";
        }
    	
    	userService.update(userForm);
  
    	return "redirect:/profile?update=true";
    }
	
}