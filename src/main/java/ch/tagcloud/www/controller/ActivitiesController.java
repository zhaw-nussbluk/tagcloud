package ch.tagcloud.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivitiesController {

    @RequestMapping(value = { "/activities" }, method = RequestMethod.GET)
    public String indexPage(Model model) {
 
        return "activities";
    }
	
}