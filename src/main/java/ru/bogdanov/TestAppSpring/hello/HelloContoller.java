package ru.bogdanov.TestAppSpring.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController

public class HelloContoller {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);    }

    private List<String> array = new ArrayList<>();
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "array", defaultValue = "") String sense) {
        if (array.isEmpty()) {
            array = new ArrayList<>();
        }
        array.add(sense);

        return array + " has been successfully added to the list";
            }

}
