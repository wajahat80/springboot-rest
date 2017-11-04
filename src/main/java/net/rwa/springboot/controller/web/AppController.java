package net.rwa.springboot.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	
	@RequestMapping("/web/")
    String home(ModelMap modal) {
        modal.addAttribute("title","CRUD Example");
        return "users";
    }
}
