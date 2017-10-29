package org.dldev.aiweb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SwaggerController {

    @RequestMapping(value = "/api")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}