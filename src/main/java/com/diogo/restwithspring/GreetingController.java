package com.diogo.restwithspring;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//Controller for Greeting Class
@RestController//Spring Web framework
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //request annnotation defines the methos as a controller requets
    @RequestMapping("/greeting")
    public Greetings greeeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }
}
