package pl.pjatk.SchoolMS.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/homepage")
    public String getIntoHomepage(){
        return "index";
    }

}
