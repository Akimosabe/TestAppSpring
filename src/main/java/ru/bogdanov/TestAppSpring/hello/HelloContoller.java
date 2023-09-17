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

        return sense + " has been successfully added to the list";
            }

    @GetMapping("/show-array")
            public String showArrayList(){
        StringBuilder output = new StringBuilder();
        for (String item : array) {
            output.append(item).append(" ");
        }
        return output.toString();
        //return array.toString(); перемудрил
    }

    HashMap<String, String> hash = new HashMap<>();
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "map", defaultValue = " ") String sense) {
        if (hash.isEmpty()) {
            hash = new HashMap<>();
        }
        hash.put(sense, sense);
        return "Added to hash map";
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return hash.toString();
    }

    @GetMapping("/show-all-length")
    public String ShowAllLength() {
        return "Array List: " + array.size() + "\n"  + " Hash Map: " + hash.size();
    }
}
