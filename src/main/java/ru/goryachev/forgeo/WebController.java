package ru.goryachev.forgeo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class WebController {

    @GetMapping("/main")
    public String mainPage () {
        return "main_page";
    }

    @GetMapping("/one")
    public String welcome () {
        return "pageone";
    }

    @GetMapping("/two")
    public String hello () {
        return "pagetwo";
    }
}
