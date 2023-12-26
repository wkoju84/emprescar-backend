package br.com.emprescar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/home")
public class HomeController {

    @GetMapping
    public String getStatus(){
        return "App is running";
    }
}
