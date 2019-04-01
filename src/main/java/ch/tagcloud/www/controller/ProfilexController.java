package ch.tagcloud.www.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.tagcloud.www.model.User;

@Controller
public class ProfilexController {

	@GetMapping(value = "/profile")
    public String indexPage(Model model) {
    	
    	model.addAttribute("userForm", new User());
 
        return "profile";
    }
	
}