package ch.tagcloud.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.tagcloud.www.service.UserService;

@Controller
public class MainController {
	
	@Autowired UserService userService;

	@GetMapping(value = { "/", "/index" })
    public String indexPage(Model model) {    
 
        return "index";
    }
	
}