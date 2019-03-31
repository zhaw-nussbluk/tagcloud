package ch.tagcloud.www.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.tagcloud.www.model.User;

@Controller
public class ProfilexController {

    @RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
    public String indexPage(Model model) {
    	
    	model.addAttribute("userForm", new User());
 
        return "profile";
    }
	
}