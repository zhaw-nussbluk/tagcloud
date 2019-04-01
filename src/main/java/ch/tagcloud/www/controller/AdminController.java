package ch.tagcloud.www.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping(value = "/admin")
    public String indexPage(Model model) {
 
        return "admin";
    }
	
}