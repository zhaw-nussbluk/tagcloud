package ch.tagcloud.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActivitiesController {
	
	@GetMapping(value = "/activities")
    public String indexPage(Model model) {
 
        return "activities";
    }
	
}