package hello.hellospring.controller;

import javax.servlet.annotation.HandlesTypes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("")
    public String index() {
        return "test";
    }

}
