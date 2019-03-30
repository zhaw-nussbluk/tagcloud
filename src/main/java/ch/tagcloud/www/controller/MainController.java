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
public class MainController {
	
	@Autowired UserService userService;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String indexPage(Model model) {    
 
        return "index";
    }
	
}