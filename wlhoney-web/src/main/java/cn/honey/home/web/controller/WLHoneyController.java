package cn.honey.home.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WLHoneyController {

    @GetMapping("/index")
    public String index() {
        Map<String, String> map = new HashMap<>();

        return "index";
    }
}
